package com.cinestop.controller;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinestop.model.FTPModel;

@Controller
public class TiwariController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/submitForm")
	public ResponseEntity<?> getFormData(@RequestBody final FTPModel ftpModel) throws SocketException, IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect(ftpModel.getSourceServerName(), 1234);
		boolean success = ftpClient.login(ftpModel.getClientUserId(), ftpModel.getClientPassword());
		//now, check if the folder exists
		ftpClient.changeWorkingDirectory(ftpModel.getClientFolderName());
		int returnCode = ftpClient.getReplyCode();
		if(returnCode == 550) {
			//does not exist, create one
			ftpClient.makeDirectory(ftpModel.getSourceFolderName());
		}
		//do the same for client
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
