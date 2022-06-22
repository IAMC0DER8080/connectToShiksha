package com.mpasc.connecttoclass.spring.utility;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
public class FileUtil {

	private static final Logger logger = Logger.getLogger(FileUtil.class.toString());

	

	public String write(MultipartFile file) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();

		try { 
			String fileName =file.getOriginalFilename().toString();
			String[] folderpath=fileName.trim().replace(" ", "").replace(".", " ").split(" ");

			String path="D:\\Tushar\\MPASC_project\\Demo\\"+folderpath[0]+formatter.format(date).toString();  ///app/clover/files/itg-portal/trainings/training-files/


			File createFile= new File(path);
			if(!createFile.exists()) { 
				logger.info("File does not exist");
				createFile.mkdir();
			}
			File convFile = new File(path,file.getOriginalFilename());


			if(convFile.createNewFile()) {
				FileOutputStream fos = new FileOutputStream(convFile);  
				fos.write(file.getBytes());
				fos.close(); 
				

				return path;
			}else {
				return "Failed";
			}
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception in while creating the n training attachment file ",e);
			return "Failed";
		}
	}
	
	public String writeSubFile(String path,Long identification,MultipartFile file) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();

		try { 
			String fileName =file.getOriginalFilename().toString();
			String[] folderpath=fileName.trim().replace(" ", "").replace(".", " ").split(" ");

			


			File createFile= new File(path);
			if(!createFile.exists()) { 
				logger.info("File does not exist");
				createFile.mkdir();
			}
			System.out.println("File Name   =========>> "+file.getOriginalFilename());
			File convFile = new File(path,String.valueOf(identification)+"."+folderpath[1]);


			if(convFile.createNewFile()) {
				FileOutputStream fos = new FileOutputStream(convFile);  
				fos.write(file.getBytes());
				fos.close(); 
				//encrypt.encrypt(createFile, createFile); 

				return path;
			}else {
				return "Failed";
			}
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception in while creating the n training attachment file ",e);
			return "Failed";
		}
	}
	

	public MultipartFile read(byte[] dir) throws IOException {
		MultipartFile file =null;

		File file1 = new File(dir.toString());



		FileInputStream fis = new FileInputStream(new String(dir) );

		return file;
	}


	public byte[] encrypt(String message)  {
		byte[] cipherText=null;
		try {
			final MessageDigest md = MessageDigest.getInstance("md5");
			final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
					.getBytes("utf-8"));
			final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			for (int j = 0, k = 16; j < 8;) {
				keyBytes[k++] = keyBytes[j++];
			}

			final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
			final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);

			final byte[] plainTextBytes = message.getBytes("utf-8");
			cipherText = cipher.doFinal(plainTextBytes);
			
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception in while encrypting the training attachment file path",e);
		}
		return cipherText;
	}

	public String decrypt(byte[] message){

		try {
			final MessageDigest md = MessageDigest.getInstance("md5");

			final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
					.getBytes("utf-8"));

			final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

			for (int j = 0, k = 16; j < 8;) {
				keyBytes[k++] = keyBytes[j++];

			}

			final SecretKey key = new SecretKeySpec(keyBytes, "DESede");

			final IvParameterSpec iv = new IvParameterSpec(new byte[8]);

			final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

			decipher.init(Cipher.DECRYPT_MODE, key, iv);

			
			final byte[]  plainText = decipher.doFinal(message);


			System.out.println("plainText   "+plainText); 
			return new String(plainText, "UTF-8");
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception in while decrypting the training attachment file path",e);
		}
		return "Failed";
	}

	public boolean deletefile(String targetPath)  {
		boolean result = false;
		try {   
			
			File file = new File(targetPath);    
			if(file.isDirectory()) { String[]entries = file.list(); 
			for(String s:entries){ 
				File currentFile = new File(file.getPath(),s);
				  
				currentFile.delete(); } 
			file.delete();
			}else if(file.isFile()) {
				file.delete(); }
			result=true;
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception in while deleting the old training attachment file ",e);
		}
		return result;
	}


}
