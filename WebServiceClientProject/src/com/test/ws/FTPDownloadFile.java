package com.test.ws;

import com.jcraft.jsch.*;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

/**
 * A program demonstrates how to upload files from local computer to a remote
 * FTP server using Apache Commons Net API.
 *
 * @author www.codejava.net
 */
public class FTPDownloadFile {

    private static int port = 22;
    private static String user = "m54178";
    private static String pass = "280916pwd";
    private static String server = "150.100.43.220";

    private Session session = null;
    private static Channel channel = null;
    private static ChannelSftp sftpChannel = null;

    private static String remoteFile1 = "/fichtemcomp/aplicativo/firmadigital/SCORING/00740636369810843965.xml";
    private static File downloadFile1 = new File("/home/aflores/Proyectos/FirmaDigital/review/reporteBS/00740636369810843965.xml");

    public FTPDownloadFile() {
        JSch jsch = new JSch();

        try {
            session = jsch.getSession(user, server, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setConfig( "PreferredAuthentications", "password" );
            session.setPassword(pass);
            session.connect();

            channel = session.openChannel("sftp");
            channel.connect();
        } catch (JSchException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void main(String[] args) {
        FTPDownloadFile ftp = new FTPDownloadFile();
        ftp.sftp(remoteFile1,downloadFile1.getPath());
        ftp.disconnect();
    }

    public void sftp(String pathFtp, String pathLocal) {
        sftpChannel = (ChannelSftp) channel;
        try {
            sftpChannel.get(pathFtp, pathLocal);

        } catch (SftpException e) {
            e.printStackTrace();
        }
    }


    public void disconnect() {
        sftpChannel.exit();
        session.disconnect();
    }

    public void testFTPClient(){
        FTPClient ftpClient = new FTPClient();

        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: using retrieveFile(String, OutputStream)
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            } else {
                System.out.println("No fue posible bajar el archivo.... ");
            }

            /* APPROACH #2: using InputStream retrieveFileStream(String)
            String remoteFile2 = "/test/song.mp3";
            File downloadFile2 = new File("D:/Downloads/song.mp3");
            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
            byte[] bytesArray = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
                outputStream2.write(bytesArray, 0, bytesRead);
            }

            success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File #2 has been downloaded successfully.");
            }
            outputStream2.close();
            inputStream.close();*/

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}