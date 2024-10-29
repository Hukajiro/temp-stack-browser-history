package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {
    private Stack<String> historyStack; 
    private Queue<String> requestQueue;  

    public BrowserHistory() {
        historyStack = new Stack<>();
        requestQueue = new LinkedList<>();
    }

    public void visitPage(String url) {
        historyStack.push(url); 
        System.out.println("Mengunjungi: " + url);
    }

    public String goBack() {
        if (!historyStack.isEmpty()) {
            return historyStack.pop(); 
        }
        return "Tidak ada riwayat.";
    }

    public void addRequest(String request) {
        requestQueue.offer(request); 
        System.out.println("Permintaan ditambahkan: " + request);
    }

    
    public String processRequest() {
        if (!requestQueue.isEmpty()) {
            return requestQueue.poll(); 
        }
        return "Tidak ada permintaan untuk diproses.";
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Kunjungi Halaman");
            System.out.println("2. Kembali");
            System.out.println("3. Tambah Permintaan");
            System.out.println("4. Proses Permintaan");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Masukkan URL halaman: ");
                    String url = scanner.nextLine();
                    browserHistory.visitPage(url);
                    break;

                case 2:
                    String lastPage = browserHistory.goBack();
                    System.out.println("Kembali ke: " + lastPage);
                    break;

                case 3:
                    System.out.print("Masukkan permintaan baru: ");
                    String request = scanner.nextLine();
                    browserHistory.addRequest(request);
                    break;

                case 4:
                    String processedRequest = browserHistory.processRequest();
                    System.out.println("Memproses: " + processedRequest);
                    break;

                case 5:
                    System.out.println("Keluar dari aplikasi.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
