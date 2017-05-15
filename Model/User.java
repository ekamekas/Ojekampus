package Model;

import java.util.regex.*;
import java.util.Date;
import java.io.Serializable;
/**
 * Abstract class User - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class User implements Serializable
{
    // instance variables - replace the example below with your own
    // id merupakan nomor identitas ojek
    protected int id;
    protected String uname;
    // nama merupakan nama dari pengemudi ojek
    protected String nama, telefon, email;
    protected Date dob;
    
    public User(int id, String uname, String nama){
        this.id = id;
        this.uname = uname;
        this.nama = nama;
        this.telefon = "";
        this.email = "";
        this.dob = null;
    }
    
    public User(int id, String uname, String nama, String telefon){
        this.id = id;
        this.uname = uname;
        this.nama = nama;
        this.telefon = telefon;
        this.email = "";
        this.dob = null;
    }
    
    public User(int id, String uname, String nama, String telefon, String email){
        this.id = id;
        this.uname = uname;
        this.nama = nama;
        this.telefon = telefon;
        this.email = email;
        this.dob = null;
    }
    
    public User(int id, String uname, String nama, String telefon, String email, Date dob){
        this.id = id;
        this.uname = uname;
        this.nama = nama;
        this.telefon = telefon;
        this.email = email;
        this.dob = dob;
    }
    
    /**
     * Getter identitas pengemudi ojek
     * 
     * @param       none            nothing
     * @return      id              mengembalikan nilai nomor identitas
     */
    public int getID()
    {
        // Method ini akan mengembalikan nilai variabel class id
        return id;
    }
    
    /**
     * Getter identitas pengemudi ojek
     * 
     * @param       none            nothing
     * @return      id              mengembalikan nilai nomor identitas
     */
    public String getUsername()
    {
        // Method ini akan mengembalikan nilai variabel class id
        return uname;
    }
    
    /**
     * Getter nama pengemudi ojek
     * 
     * @param       none             nothing
     * @return      nama             mengembalikan nama pengemudi ojek 
     */
    public String getNama()
    {
        // Method ini akan mengembalikan nilai variabel class nama berupa String 
        return nama;
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public String getTelefon()
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        return telefon;
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public String getEmail()
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        return email;
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public Date getDOB()
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        return dob;
    }
    
    /**
     * Setter identitas pengemudi ojek
     * 
     * @param       id              nilai id yang akan diset
     * @return      none            nothing 
     */
    public void setID(int id)
    {
        // Method ini akan mem-passing parameter id ke variabel id
        // this.id merupakan penamaan alternatif dari variabel class id
        this.id = id;
    }
    
    public void setUsername(String uname)
    {
        // Method ini akan mem-passing parameter id ke variabel id
        // this.id merupakan penamaan alternatif dari variabel class id
        this.uname = uname;
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public void setNama(String nama)
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        this.nama = nama;
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public boolean setTelefon(String telefon)
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        Pattern pattern = Pattern.compile("[0-9]{11,13}");
        Matcher matcher = pattern.matcher(telefon);
        if(!matcher.matches()){
            return false;
        } else{
            this.telefon = telefon;
            return true;
        }
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public boolean setEmail(String email)
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        Pattern pattern = Pattern.compile(".+[@]{1}+.+[.]{1}+.+");
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            this.email = email;
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public void setDOB(Date dob)
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        this.dob = dob;
    }
}
