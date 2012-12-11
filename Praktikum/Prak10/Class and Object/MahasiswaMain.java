import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaMain {
	public static void main(String[] args) {
		File file = new File("Mahasiswa.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		List<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();
		
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			while(dis.available() != 0) {
				//memecah text perbaris menjadi kolom sesuai dengan pemisah koma
				String line = dis.readLine();
				String[] data = line.split(",");
				
				Mahasiswa m = new Mahasiswa();
				m.setNpm(data[0]);
				m.setNama(data[1]);
				m.setAlamat(data[2]);
				
				listMahasiswa.add(m);
			}
		}
		
		catch (IOException ex) {
			System.out.println("File" + file.getName() + "tidak ketemu !");
			System.out.println("Exception : " + ex.getMessage());
		}
		
		for (Mahasiswa mhs : listMahasiswa) {
			System.out.println("======================");
			System.out.println("NPM : " + mhs.getNpm());
			System.out.println("Nama : " + mhs.getNama());
			System.out.println("Alamat : " + mhs.getAlamat());
		}
	}
} 