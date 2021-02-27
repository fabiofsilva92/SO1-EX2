package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");
		return os + " v. " + version + " arch. " +arch;
	}
	
	public void listarProcessos() {
		
		String sistemaOp = os();
		
		if(sistemaOp.contains("Windows")) {
			try {
				String lista = "TASKLIST /FO TABLE";
				Process tasklist = Runtime.getRuntime().exec(lista);
				InputStream fluxo = tasklist.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha;
				linha = buffer.readLine();
				while (linha !=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				} 
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else {
			//linux
			try {
				String lista = "ps -ef";
				Process tasklist = Runtime.getRuntime().exec(lista);
				InputStream fluxo = tasklist.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha;
				linha = buffer.readLine();
				while (linha !=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				} 
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void killProcessByPID(int pid) {
		
		String sistemaOp = os();
		
		if(sistemaOp.contains("Windows")) {
			String kill = "TASKKILL /PID ";
			try {
				Runtime.getRuntime().exec(kill + pid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String kill = "kill -9 ";
			try {
				Runtime.getRuntime().exec(kill + pid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void killProcessByName(String name) {
		
		String sistemaOp = os();
		
		if(sistemaOp.contains("Windows")) {
			String kill = "TASKKILL /IM ";
			try {
				Runtime.getRuntime().exec(kill + name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String kill = "pkill -f ";
			try {
				Runtime.getRuntime().exec(kill + name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


