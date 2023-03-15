package JavayaGiris5.Strings;
import java.sql.SQLOutput;
import java.util.Scanner;
public class StringIfadeler {
    public static void main(String[] args) {

        /* STRING IFADELER NOTLAR
        *  String ifadeler "immutable" yani degistirilemez metotlardir. String sinifi java.lang kutuphanesinde bulunur.* */

        // String ifade olusturma
        char array1[] = {'B','u','r','s','a'};
            String city= new String(array1); //1.yol

        String array2= "I am learning JAVA language"; //2.yol

        System.out.println(array1); //char array1 yaptiginda
        System.out.println(city +" is the city where I was born and now " + array2 + " in Denizli Pamukkale University!");

        //----------------------------------------------------------------------------------------------------------------------
        // String nesnesinin uzunlugu - length metodu (bosluk karakterini de sayar)
        int a1 = array1.length; //char array1 i tanimlama farkindan dolayi length() degil length kullandik
        int a2= city.length();
        int b= array2.length();

        System.out.println("Array2'nin uzunlugu: "+ b + "\nArray1 veya city dizilerin uzunlugu: " + a2);

        //----------------------------------------------------------------------------------------------------------------------
        // Karakter katarlarini birlestirmek - concat metodu ve + operatoru ile birlestirme

        String d1="String";
        String d2="Nesnesi";
        String d3=d1.concat(d2); // d1+d2
            System.out.println(d3); //1.yol
            System.out.println(d1+d2); //2.yol

        //----------------------------------------------------------------------------------------------------------------------
        // String Nesnelerini Karsilastirma
            // 1-) Java'da iki string tipteki iki veriyi == ile karsilastirdigimizda "nesneleri" kontrol eder! Fakat veriler ayni
            // nesneler farkli ise hatali sonuc verebilir. Dolayisiyla pek bunu kullanmayiz...

        String name1="Mehmet";
        String name2="Furkan";
        if(name1==name2)
            System.out.println("Isimler ayni!");
        else
            System.out.println("Isimler farkli!");

            // 2-) EQUALS ve EQUALSIGNORECASE Metotlari
            // nesneler ayni ise true degilse false dondurur.
            // EQUALS=harf duyarliligi var - EQUALSIGNORECASE=harf duyarliligi yok

        String name3="Furkan";
        String name4="furkan";

        System.out.println(name2+" - " +name4 + " = " + name2.equals(name4));
        System.out.println(name2+" - " +name3 + " = " + name2.equals(name3));
        System.out.println(name3+" - " +name4 + " = " + name3.equalsIgnoreCase(name4)); //harf duyarliligi yok

        //----------------------------------------------------------------------------------------------------------------------
        // compareTo() ve compareToIgnore() metotlari ile buyukluk kontrolleri
            // buyuk kucuk kontrolu derken burada hangisi daha once veya sonra geliyor karsilastirmasi yapilmaktadir.
            // a ile b karsilastirildiginda a, b'den kucuktur.
            // compareTo()= harf duyarliligi var. Digerinde yok!
        System.out.println(name3.compareTo(name4));
        System.out.println(name3.compareToIgnoreCase(name4));

        //----------------------------------------------------------------------------------------------------------------------
        // regionMatches() metodu ile belirli bir bolgenin karsilastirilmasi/aranmasi
        String array3="learning";
        boolean k= array2.regionMatches(0,array3,0,array3.length()); //toffset array2 nin baslangic indisi, ooffset array3 un baslangic indisi
            if(k==true)
                System.out.println(array2+ " içerisinde aranan bölgede " + array3 + " bulundu!");
            else
                System.out.println(array2+ " içerisinde aranan bölgede " + array3 + " bulunamadi!");

        //----------------------------------------------------------------------------------------------------------------------
        // startsWith() ve endsWith() metotlari ile baslangic ve bitis kontrolu
        // baslangic ve son ifadelerin nasil basladigini kontrol ettirir.
        String array4="JAVA Programlama Dili";
        boolean kontrol;

        kontrol=array4.startsWith("JAVA "); //true
            System.out.println(kontrol);
        kontrol=array4.startsWith("Java"); //false
            System.out.println(kontrol);
        kontrol=array4.endsWith(" Dili"); //true
            System.out.println(kontrol);
        kontrol=array4.endsWith(" Dil"); //false
            System.out.println(kontrol);

            // startsWith metodunun asiri yuklenmis hali de vardir = bu sayede hangi karakterden baslayacagini belirtebiliriz.
        kontrol=array4.startsWith("AVA",1); // 1. indisten sonrasini karsilastiracak => true
            System.out.println(kontrol);

        //----------------------------------------------------------------------------------------------------------------------
        // getChars() metodu ile string icindeki bir bolumu diziye aktarma
            // genel kullanim: getChars(int baslangic, int bitis, char kaynakDizi[], int kaynakIndis)

        String array5="Bu bolumde String nesnesinin metotlarini ogreniyoruz";
        char[] kaynakDizi= new char[6];
        char[] kaynakDizi2= new char[9];
        char[] kaynakDizi3= new char[11];

        array5.getChars(11,17,kaynakDizi,0);
            System.out.println(kaynakDizi);
        array5.getChars(18,27,kaynakDizi2,0);
            System.out.println(kaynakDizi2);
        array5.getChars(41,52,kaynakDizi3,0);
            System.out.println(kaynakDizi3);

        //----------------------------------------------------------------------------------------------------------------------
        // charAt() metodu ile string icindeki karakterlere ulasmak
            // bu metotta string nesnesi icinden belli bir noktadaki tek bir karakteri secmek icin kullanilir.
        String alfabe="ABCÇDEFGĞHIİLMNOPRSŞTUÜVYZ";
        System.out.println("Alfabenin 10. harfi: " + alfabe.charAt(9)); // H

        //----------------------------------------------------------------------------------------------------------------------
        // toCharArray() metodu ile string bir ifadeyi karakter dizine cevirmek
        String array6="Karakter dizisine aktarilacak string";
        int uzunluk=array6.length(); //dizinin uzunlugunu bulduk
        char [] karakterDizisi= new char[uzunluk]; //karakter dizisi tanimladik
        karakterDizisi=array6.toCharArray(); // string ifadeyi diziye cevirdik
            //dizimizi yazdiralim
            for(int i=0; i<=array6.length()-1; i++){ //i<uzunluk da diyebiliriz, bu sekilde yazilis da olabilir.
                System.out.print(karakterDizisi[i]);
            }

        //----------------------------------------------------------------------------------------------------------------------
        // indexOf() ve lastIndexOf() metotlari ile string icerisinde karakter arama
            // indexOf() metodu, string nesnesi icinde aranilan karakterin "ilk bulundugu indis" degerini verir.
            // lastIndexOf() metodu ise, string nesnesi icinde aranilan karakterin "son bulundugu indis" degerini verir.
        String array7="Bu arama yapabilmek icin test cumlesidir";
            System.out.println("\n 'a' karakteri icin ilk indis: " + array7.indexOf("a"));
            System.out.println(" 'a' karakteri icin son indis: " + array7.lastIndexOf("a"));
            System.out.println(" 'bilmek icin tes' ifadesi icin ilk indis: " + array7.indexOf("bilmek icin tes"));
            //NOT: Eger eleman bulunursa indis degeri dondurur fakat bulamazsa negatif deger dondurur!!!
            System.out.println(" 'deneme' kelimesi icin ilk indis: " + array7.indexOf("deneme"));

        //----------------------------------------------------------------------------------------------------------------------
        //STRING DUZENLEME METOTLARI
        // substring() metodu ile string icinden bir bolum secme, kullanimi --> String : substring (int ilk indis , int son indis)
        String array8="Bu ornek substring metodunun kullanimi icin yapildi.";
        String altDizge="";
        String altDizge2="";
            altDizge=array8.substring(9,18);
            altDizge2=array8.substring(29,38);
        System.out.println(altDizge+"\n"+altDizge2);

        //----------------------------------------------------------------------------------------------------------------------
        // replace() metodu ile string icindeki karakteri degistirme
            // genel kullanimi --> String : replace(char orjinalKarakter, char degistirilenKarakter)
        String array9="Bu ornek replace metodunun kullanimi icin yapildi.";
        String dizge="";
            System.out.println("Nesnemizin orjinal hali: "+array9);
        dizge=array9.replace('e','o');
            System.out.println("Nesnemizin degistirilimis hali: "+dizge); //Bu ornok roplaco motodunun kullanimi icin yapildi
        dizge=dizge.replace("yapildi","tasarlandi");
            System.out.println("Nesnemizin tekrar degistirilmis hali: "+dizge);

        //----------------------------------------------------------------------------------------------------------------------
        // trim() metodu ile string ifadenin yanindaki bosluklari silme
            // Bu metot nesnemizin sagindaki ve solundaki bosluklari silerek duzenlenmis bir kopyasini dondurur!
        String array10="    Bu cumlenin basindaki ve sonundaki "
                            +"bosluklar trim metoduyla silinecektir.     ";
        System.out.println("Normal hali:  "+array10);
        System.out.println("Duzenlenmis hali: "+array10.trim());

        //----------------------------------------------------------------------------------------------------------------------
        // toUpperCase() ve toLowerCase() metotlari ile harf kipini degistirme
            // [toUpperCase() metodu --> buyuk harfe cevirir]  [toLowerCase() metodu --> kucuk harfe cevirir]
        String array11="Bu OrNeK HaRf KiPi DeGiSiMi MeToTlArI iCiN yApIlDi.";
            String buyuk=array11.toUpperCase();
            String kucuk=array11.toLowerCase();
                System.out.println(buyuk);
                System.out.println(kucuk);
        //----------------------------------------------------------------------------------------------------------------------
        // valueOf() metodu ile veri tiplerini string veri tipine cevirme
        int    i=10;
        double pi= 3.14;
        float  f= 11.f;
        char   c= 'c';
        Object o= new String("Deneme");
        String s=""; // donusturduklerimizi buna ekleyecegiz.
            s+=String.valueOf(i);
            s+=" - "+String.valueOf(pi);
            s+=" - "+String.valueOf(f);
            s+=" - "+String.valueOf(c);
            s+=" - "+String.valueOf(o);
        System.out.println(s);

        //----------------------------------------------------------------------------------------------------------------------
        // StringTokenizer ve StringBuffer Siniflari
        // DEVAM EDECEK...
    }
}
