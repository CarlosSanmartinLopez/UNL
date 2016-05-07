/*
 * Copyright (C) 2016 Carlos Sanmartín López
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package OOP;

/**
 *
 * @author Carlos Sanmartín López
 */
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PersonalInformation
{
    private static String strName, strSurname, strBirthDate,
            strID, strPhone, strAddress, strCellPhone, strInfo;
    
    private static int intAge;     
    
    private static final Calendar today = new GregorianCalendar();
    private static final Calendar birth = new GregorianCalendar();
    
    private static Date currentDate = new Date(); 
    
    public PersonalInformation() 
    {
        strName = "";
        strSurname = "";
        strBirthDate = "";
        strID = "";
        strPhone = "";
        strAddress = "";
        strCellPhone = "";
        intAge = 0;
        today.setTime(currentDate);
    }   
    
    public static String getStrName() 
    { return strName; }

    public static void setStrName(String aStrName) 
    { strName = aStrName; }

    public static String getStrSurname() 
    { return strSurname; }

    public static void setStrSurname(String aStrSurname) 
    { strSurname = aStrSurname; }

    
public static String getStrBirthDate() 
    { return strBirthDate; }

    public static void setStrBirthDate(String aStrBirthDate) 
    { 
        strBirthDate = aStrBirthDate; 
        try 
        {        
            int factor=0;
            Date birthDate=new SimpleDateFormat("dd-MM-yyyy").parse(aStrBirthDate);

            birth.setTime(birthDate);

            if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) 
            {
                if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) 
                {
                    if (today.get(Calendar.DATE) < birth.get(Calendar.DATE)) 
                    { factor = -1; }
                } 
                else { factor = -1; }
            }
            setIntAge((today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor);
        } catch (ParseException e) { setIntAge(-1); }        
    }

    public static int getIntAge() 
    { return intAge; }

    private static void setIntAge(int aIntAge) 
    { intAge = aIntAge; }

    public static String getStrID() 
    { return strID; }

    public static void setStrID(String aStrID) 
    { strID = aStrID; }

    public static String getStrPhone() 
    { return strPhone; }

    public static void setStrPhone(String aStrPhone) 
    { strPhone = aStrPhone; }

    public static String getStrAddress() 
    {  return strAddress; }

    public static void setStrAddress(String aStrAddress) 
    { strAddress = aStrAddress; }

    public static String getStrCellPhone() 
    { return strCellPhone; }

    public static void setStrCellPhone(String aStrCellPhone) 
    { strCellPhone = aStrCellPhone; }
    
    public static String getStrInfo()
    {
        strInfo = "------\n"+
                "El Nombre es: "+getStrName()+" "+getStrSurname()+" "+
                "y su Cédula es: "+getStrID()+".\n"+
                "Nació el "+getStrBirthDate()+" "+
                "y tiene "+getIntAge()+" años de edad.\n"+
                "Vive en "+getStrAddress()+" y sus números de contacto son:\n"+
                getStrPhone()+" - "+getStrCellPhone()+ "\n"+
                "------\n";
        return strInfo;
    }
    
    public static void main(String[] args) 
    {
        PersonalInformation pInfo = new PersonalInformation();
        
        InputStream in = System.in;
        Scanner sc = new Scanner(in,"ISO-8859-1");
        
        System.out.println("Ingrese los Siguentes Datos");
        
        System.out.print("Nombres: ");
            pInfo.setStrName(sc.nextLine());
        System.out.print("Apellidos: ");
            pInfo.setStrSurname(sc.nextLine());
        System.out.print("Fecha de Nacimiento (dd-mm-aaaa): ");
            pInfo.setStrBirthDate(sc.nextLine());
        System.out.print("Cédula: ");
            pInfo.setStrID(sc.nextLine());
        System.out.print("Teléfono: ");
            pInfo.setStrPhone(sc.nextLine());
        System.out.print("Dirección: ");
            pInfo.setStrAddress(sc.nextLine());
        System.out.print("Celular: ");
            pInfo.setStrCellPhone(sc.nextLine());
                        
        System.out.println(pInfo.getStrInfo());
    }
}
