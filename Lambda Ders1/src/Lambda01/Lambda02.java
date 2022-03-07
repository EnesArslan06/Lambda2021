package Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));

        ciftKareMaxEleman(list);
        System.out.println();
        System.out.println("*************");
        elemanToplama1(list);
        System.out.println();
        System.out.println("*************");
        elemanToplama2(list);
        System.out.println();
        System.out.println("*************");
        carpim(list);
        System.out.println();
        System.out.println("*************");
        carpim2(list);
        System.out.println();
        System.out.println("*************");
        enKucuk(list);
    }

//Listin cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz.

    public static void ciftKareMaxEleman(List<Integer> list) {
        //integer clasinda max elemaný bulan bir class var
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);

        //Optional<Integer> maxEl=list.stream().filter(t-> t%2==0).map(t->t*t).reduce(Math::max);
        //math max da kullanýlabilir, ancak (Integer::max) daha spesific oldugu icin daha hizli calisir.
        //reduce () return edilen eleman null yada int'ten buyuk olur ihtimali icin Java
        // Optional classi gerekli kiliyor.

        System.out.println(maxEl);

    }

    //Listteki tum elemanlarin toplamini yazdiriniz
    //Lambda experession kullanacaz
    public static void elemanToplama1(List<Integer> list) {
        int toplam = list.stream().reduce(0, (x, y) -> x + y);
        //x  her zaman ilk degerini atanan degerden alir.
        // y ' da her zaman degerini list.stream() ' den alir.
        //x ilk degerden sonraki degerleri islemden air
        //System.out.println(list.stream().reduce(0, (x,y) ->x+y)); buda ayni sey oda calisir
        System.out.println(toplam);
    }

    public static void elemanToplama2(List<Integer> list) {
        Optional<Integer> toplam = list.stream().reduce(Math::addExact);
        // Optional<Integer> toplam=list.stream().reduce(Integer::sum);//integer classinda su methodu ile topla diyoruz
        System.out.println(toplam);
    }

    //List teki cift elemanlarin carpimini yazdirin
    //Method reference kullanin
    public static void carpim(List<Integer> list) {
        Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        //Math::multiplyExact her elemani carpma methodudur

        System.out.println(carp);
    }

    //List teki cift elemanlarin carpimini yazdirin
    //Lambda expression kullanin

    public static void carpim2(List<Integer> list) {

        int carp2 = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> x * y);
        System.out.println(carp2);
    }

    //List teki elemanlardan en kucugunu 4 farkli yontem ile yazdiriniz
    public static void enKucuk(List<Integer> list) {
        //Yontemler ;
        //Optional<Integer> enKucuk=list.stream().reduce(Math::max);//Method reference
        //Optional<Integer> enKucuk=list.stream().reduce(Integer::min); //Method reference
        //Optional<Integer>enKucuk=list.stream().reduce(Lambda02::minbulMethod)//kendimiz method olusturduk alt satirda
        Integer enKucuk=list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y ? x:y);//Bu yontemde Lambda expression...
                                                                                //sana y degerleri gelecek onlari baslangiz
        //noktasi olan x degerinden itibaren kýyaslayarak minumum degeri bul. Baslangic degerini MAX.VALUE yapmamizin nedenide;
        //x in en buyuk degerin den kucuk olacak.Yani ilk kiyasmalama degerimiz en buyuk sayi, ondan kucuklari bulacaz.
        //en buyugu bulmak isteseydik INTEGER.MINVALUE kullanmaliydik.
        System.out.println(enKucuk);
  }
  public static int minbulMethod(int x, int y){//sana x ve ye degerleri gonderecem onlari kýyasla en kucuk olaný getir
     return x<y ? x : y;
  }

}