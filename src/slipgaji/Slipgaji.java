/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slipgaji;

/**
 *
 * @author adhary
 */
import java.io.*;

class gaji{
    private String nama_10120205;
    private int lama_kerja_10120205;
    private double gaji_pokok_10120205;
    private int lembur_10120205;
    private double hitung_lembur_10120205;
    protected double tunjangannya_10120205;
    private double hitung_gaji_kotor_10120205;
    private double hitung_pajak_10120205;
    private double gaji_bersih_10120205;
    
    // nama_fied_3digit_nim
    public void set_nama(String nm){
        this.nama_10120205 = nm;
    }
    
    public String get_nama(){
        return nama_10120205;
    }
    
    public void set_lama_bekerja(int lm_ker){
        this.lama_kerja_10120205 = lm_ker;
    }
    
    public int get_lama_kerja(){
        return lama_kerja_10120205;
    }
    
    public double get_hitung_gaji_pokok(){
        if (lama_kerja_10120205 <= 10){
            gaji_pokok_10120205 = 1000000;
        }
        else if(lama_kerja_10120205 > 10 ){
            gaji_pokok_10120205 = 2000000;
        }
        return gaji_pokok_10120205;
    }
    
    public void set_lembur(int lm){
        this.lembur_10120205 = lm;
    }
    
    public int get_lama_lembur(){
        return lembur_10120205;
    }
    
    public double get_hitung_lembur(){
        hitung_lembur_10120205 = lembur_10120205 * 15000;
        return hitung_lembur_10120205;
    }
    
    public double get_gaji_kotor(double tunjangannya_10120205){
        hitung_gaji_kotor_10120205 =  gaji_pokok_10120205 + hitung_lembur_10120205 + tunjangannya_10120205;
        return hitung_gaji_kotor_10120205;
    }
    
    public double get_hitung_pajak(){
        hitung_pajak_10120205 = hitung_gaji_kotor_10120205 * 0.1;
        return hitung_pajak_10120205;
    }
    
    public double get_hitung_gaji_bersih(){
        gaji_bersih_10120205 = hitung_gaji_kotor_10120205 - hitung_pajak_10120205;
        return gaji_bersih_10120205;
    }
    
}

class tunjangan extends gaji{
    public double get_hitung_tunjangan(int lama_kerja_10120205){
        tunjangan t = new tunjangan();
        if (lama_kerja_10120205 <=  10){
            t.tunjangannya_10120205 = 500000;
        }
        else if(lama_kerja_10120205 > 10 ){
            t.tunjangannya_10120205 = 700000;
        }
        return t.tunjangannya_10120205;
    }
}

public class Slipgaji {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        // pembuatan objek
        gaji g = new gaji();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         tunjangan t = new tunjangan();
        
        System.out.println("Program Penggajian PT. Jaya Susah Selalu");
        System.out.println("===================================");
        System.out.print("Masukan Nama Pegawai  =  ");
        g.set_nama(br.readLine());
        System.out.print("Masukkan  Lama Bekerja = ");
        g.set_lama_bekerja(Integer.parseInt(br.readLine()));
        System.out.print("Lembur / Jam = ");
        g.set_lembur(Integer.parseInt(br.readLine()));
        
        System.out.println("");
        System.out.println("Slip Gaji");
        System.out.println("=======================");
        System.out.println("Nama Pegawai = "+g.get_nama());
        System.out.println("Gaji Pokok = "+g.get_hitung_gaji_pokok());
        System.out.println("Tunjangan = "+t.get_hitung_tunjangan(g.get_lama_kerja()));
        System.out.println("Lembur  = "+g.get_hitung_lembur());
        System.out.println("Gaji Kotor = "+g.get_gaji_kotor(t.get_hitung_tunjangan(g.get_lama_kerja())));
        System.out.println("Pajak   = "+g.get_hitung_pajak());
        System.out.println("Gaji Bersih  = "+g.get_hitung_gaji_bersih());
    }
    
}
