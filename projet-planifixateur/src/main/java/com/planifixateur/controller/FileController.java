package com.planifixateur.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.planifixateur.message.ResponseFile;
import com.planifixateur.message.ResponseMessage;
import com.planifixateur.model.FileDB;
import com.planifixateur.model.dto.FileDBDto;
import com.planifixateur.service.FileStorageService;

@Controller
@CrossOrigin
public class FileController {

	@Autowired
	private FileStorageService storageService;

	@PostMapping("/upload")
	public ResponseEntity<FileDBDto> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			FileDB fileDb = storageService.store(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
//			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			return new ResponseEntity<>(FileDBDto.from(fileDb), HttpStatus.OK);
		} catch (Exception e) {
			FileDB fileDbErreur = new FileDB();
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message + FileDBDto.from(fileDb)));
			return new ResponseEntity<>(FileDBDto.from(fileDbErreur), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(dbFile.getId()).toUriString();

			return new ResponseFile(dbFile.getId(), dbFile.getName(), fileDownloadUri, dbFile.getType(),
					dbFile.getData().length, dbFile.getProjet());
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		FileDB fileDB = storageService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}

	@DeleteMapping("/file/{id}")
	public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String id) {
		String message = "";
		try {
			FileDB fileDB = storageService.deleteFile(id);
			message = "Suppress the file successfully: " + fileDB.getName();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not delete the file: " + FileDB.class.getName() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
}
