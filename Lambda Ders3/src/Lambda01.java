import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Lambda01 {
    /*
       1) Lambda "Functional Programming"
          "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
       2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
       3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
       4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
          Lambda kullanmak hatasız code kullanmaktır.
    */
    public static void main(String[] args) {


        List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,5));

        prinElStructured(list);
        System.out.println();
        System.out.println(" **********");

        printElfunctional(list);

        System.out.println();
        System.out.println(" **********");

        printElfunctional1(list);

        System.out.println();
        System.out.println(" **********");

        printCiftElStructured(list);//12 34 22 60 42

        System.out.println();
        System.out.println(" **********");

        printCiftElFunctional1(list);

        System.out.println();
        System.out.println(" **********");

        printCiftElFunctional2(list);

        System.out.println();
        System.out.println(" **********");

        printCiftAltmisdanKucuk(list);//12 34 22 42  60 i yazdirmadi

        System.out.println();
        System.out.println(" **********");

        printTekYirmidenBuyuk(list);//13 65 3 7 34 22 60 42 5

        System.out.println();
        System.out.println(" **********");

        ciftKareYazdir(list);//144 1156 484 3600 1764

        System.out.println();
        System.out.println(" **********");

        kupTekBirFazlasiYazdir(list);//2198 274626 28 344 126

        System.out.println();
        System.out.println(" **********");

        ciftElemanKarekok(list);//3.4641016151377544 5.830951894845301 4.69041575982343 7.745966692414834 6.48074069840786

        System.out.println();
        System.out.println(" **********");

        enBuyukElemanYazdirma(list);//Optional[65]

        System.out.println();
        System.out.println(" **********");
    }

    //structred Programing ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz.

    public static void prinElStructured(List<Integer> list) {//method olarak bu sekilde yazdirdik.

        for (Integer w : list) {

            System.out.print(w+" ");//12 13 65 3 7 34 22 60 42 5
        }


    }

    //Functional Programing ile(Lambda) list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz.

    public static void printElfunctional(List<Integer> list) {

        list.stream().forEach(t->System.out.print(t+" "));//Lambda Expression:Lambda ifadesi
        //stream(); bu method datalari yukaridan asagi akis sekline getirir.
        //forEach(); datalarin parametresine göre herbir elemani isler
        //t-> : lambda operatoru
        //Lambda expression yapisi cok tavsiye edilmez daha cok METHOD PEREFENCE kullanilir

    }


    //Method Perefence--> kendi create ettigimiz veya javadan aldigimiz method ile
    //Classname::Methodname    -----------Ezberlenecekkkkkkkkkk

    public static void printEl(int t) {// bu methoda biz int verecez o yazdiracak bu yazdirma methodudur.
        //refe edilecek methoddur
        System.out.print(t+" ");
    }

    public static void printElfunctional1(List<Integer> list) {//yukaridaki listi kullanacak ancak yazma methodu olarak yukaridaki methodu
        //referans gosterecez

        list.stream().forEach(Lambda01::printEl);//Lambda clasındaki printEl methodunu al getir dedik
        //once class name sonra method name arasina iki nokta ust uste

        //stream() methodu selale haline getirir. for each onlarin hepsini ceker.


    }

    //structured programing ile list elemanlarinin cift olanlarini ayni satirda aralarinda bosluk olacak sekilde yazdiriniz.

    public static void printCiftElStructured(List<Integer> list) {

        for (Integer w : list) {//uzun yolu bu
            if (w%2==0) {
                System.out.print(w+" ");
            }
        }



    }

    //functional programing ile list elemanlarinin cift olanlarini ayni satirda aralarinda bosluk olacak sekilde yazdiriniz.

    public static void printCiftElFunctional1(List<Integer> list) {

        list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);

        //filter(); methodu bir akis icerisinde elemanlari filitreler. if' in sart gorevini gorur.
    }

    public static boolean ciftBul(int i) {//refere edilecek tohum method

        return i%2==0;//bu method gelen i leri 2 ye bolunup bolunmedigine gore return ediyor.
    }

    public static void printCiftElFunctional2(List<Integer> list) {//yukaridaki lambda cift bul methodu calisti. Cift ise boolean olarak doner
        //cift sayi ise return doner o sayiyi dondurur.

        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);//cift bul methodu ile bulduk, print el ile yazdirdik tek satirda

    }

//functional programing ile list elemanlarinin cift olanlarinin 60 dan kucuk olanlarini
//ayni satirda aralarinda bosluk olacak sekilde yazdiriniz.

    public static void printCiftAltmisdanKucuk(List<Integer> list) {

        list.stream().filter(t->t%2==0 & t<60).forEach(Lambda01::printEl);//2 tane filtre uyguladik.
    }

//functional programing ile list elemanlarinin tek olanlarini veya 20 den buyuk olanlarini
//ayni satirda aralarinda bosluk olacak sekilde yazdiriniz.

    public static void printTekYirmidenBuyuk(List<Integer> list) {

        list.stream().filter(t->t%2==1 || t>20).forEach(Lambda01::printEl);//bazi sayilar tek oldugu icin bazilari
        //20 den buyuk oldugu icin sarti sagladi
//lambda operatoru verilir bu  isrete t->
    }

//functional programing ile list elemanlarinin cift olanlarinin karelerini
//ayni satirda aralarinda bosluk olacak sekilde yazdiriniz.

    public static void ciftKareYazdir(List<Integer> list) {

        list.stream().filter(Lambda01::ciftBul).map(t-> t*t).forEach(Lambda01::printEl);//map kullaniyoruz. Elemanlar uzerinde degisiklik olacagi
        //icin map kullaniriz. Once ciftleri bulduk sonra map ile kareleri aldik
        //map ile genelde matematiksel islemler kullanilir.
    }

    public static void ciftKareYazdir2(List<Integer> list) {

        //list.stream().filter(Lambda01::ciftBul).map(Math::pow).forEach(Lambda01::printEl);
        //java nin math clasindan pow methodunu alabiliriz. veya String::toLowerCase yapabiliriz falan falan

    }

//functional programing ile list elemanlarinin tek olanlarinin kuplerinin bir fazlasini
//ayni satirda aralarinda bosluk olacak sekilde yazdiriniz.

    public static void kupTekBirFazlasiYazdir(List<Integer> list) {

        list.stream().filter(t-> t%2==1).map(t->(t*t*t)+1).forEach(Lambda01::printEl);
    }

//functional programing ile list elemanlarinin cift olanlarinin karekoklerini
//ayni satirda aralarinda bosluk olacak sekilde yazdiriniz.

    public static void ciftElemanKarekok(List<Integer>list) {//printEL methodu ile yapamadik o int bu math metodlari double istiyor

        list.stream().
                filter(t-> t%2==0).
                map(Math::sqrt).
                forEach(t->System.out.print(t+" "));
        //normalde kod yazanlar bu sekilde yazdirir. Her satirda bir method calisir. Yanlarinada aciklama yazilabilir
    }

//Listin en buyuk elemanini yazdirin

    public static void enBuyukElemanYazdirma(List<Integer>list) {

        Optional<Integer>maxSayi=list.stream().reduce(Math::max);//bu bize birsey verecek bunu bir variableye atayacaz.
        //Optional clasindan <Integer> datatype.--Optional<Integer> bos olan veya olmayan deger iceren veya icermeyen bir
        //kab gibi classdir. Burada listten gelen en buyuk sayiyi Optional clasindan bir nesne olusturarrak ona atadik.
        //reduce (); methodu icerisinde parametre olan bir cok elementleri bir seylere cevirir tek eleman olarak dondurur.
        //azaltmak anlamina gelir. bircok datayi tek bir dataya cevirmek icin kullanilir.
        //math classindaki Math::max methodu  listedeki en buyuk sayiyi bulup getirir.

        System.out.println(maxSayi);
    }



}