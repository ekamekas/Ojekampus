
/**
 * Write a description of class Administrasi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */public class Administrasi
{
    // instance variables - replace the example below with your 

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananDitugaskan(Pesanan pesan, Ojek pelayan)
    {
        // put your code here
        pesan.setStatusSelesai(false);
        pesan.setStatusDiproses(true);
        pesan.setPelayan(pelayan);
        ojekAmbilPesanan(pesan, pelayan);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void ojekAmbilPesanan(Pesanan pesan, Ojek pelayan)
    {
        // put your code here
        pelayan.setStatus(StatusOjek.JEMPUT);
        pelayan.setPesanan(pesan);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
        public static void ojekLepasPesanan(Ojek pelayan)
    {
        // put your code here
        pelayan.setStatus(StatusOjek.IDLE);
        pelayan.setPesanan(null);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananDibatalkan(Ojek pelayan)
    {
        // put your code here
        pelayan.getPesanan().setStatusSelesai(false);
        pelayan.getPesanan().setStatusDiproses(false);
        pelayan.setPesanan(null);
        ojekLepasPesanan(pelayan);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananSelesai(Ojek pelayan)
    {
        // put your code here
        pelayan.getPesanan().setStatusSelesai(true);
        pelayan.getPesanan().setStatusDiproses(false);
        pelayan.setPesanan(null);
        ojekLepasPesanan(pelayan);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananDibatalkan(Pesanan pesan)
    {
        // put your code here
        ojekLepasPesanan(pesan.getPelayan());
        pesan.setStatusSelesai(false);
        pesan.setStatusDiproses(false);
        pesan.setPelayan(null);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananSelesai(Pesanan pesan)
    {
        // put your code here
        ojekLepasPesanan(pesan.getPelayan());
        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
        pesan.setPelayan(null);
    }
}
