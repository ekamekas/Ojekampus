import java.util.*;

/**
 * Kelas ini digunakan untuk melakukan komparasi antar dua objek Mahasiswa
 */
class MahasiswaComparator implements Comparator<Mahasiswa> {
    @Override
    public int compare(Mahasiswa siswa1, Mahasiswa siswa2) {
        return siswa1.getNilai() - siswa2.getNilai();
    }
}