import java.util.*;

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
        System.out.println();
        System.out.println("*************");
        farklari(list);
        System.out.println();
        System.out.println("*************");
        onbestenBykKckTekSayi(list);
        System.out.println();
        System.out.println("*************");
        ciftKareKckByg(list);
        System.out.println();
        System.out.println("*************");
        tekKareBygKck( list);
    }

//Listin cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz.

    public static void ciftKareMaxEleman(List<Integer> list) {
        //integer clasinda max elemanı bulan bir class var
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);

        //Optional<Integer> maxEl=list.stream().filter(t-> t%2==0).map(t->t*t).reduce(Math::max);
        //math max da kullanılabilir, ancak (Integer::max) daha spesific oldugu icin daha hizli calisir.
        //reduce () return edilen eleman null yada int'ten buyuk olur ihtimali icin Java
        // Optional classi gerekli kiliyor.

        System.out.println(maxEl);

    }

    //Listteki tum elemanlarin toplamini yazdiriniz
    //Lambda experession kullanacaz
    public static void elemanToplama1(List<Integer> list) {
        int toplam = list.stream().reduce(0, (x, y) -> x + y);
        //x  her zaman ilk degerini atanan degerden alir.0 burada atanan ilk degerdir
        // y ' da her zaman degerini list.stream() ' den alir.
        //x ilk degerden sonraki degerleri islemden alir
        //System.out.println(list.stream().reduce(0, (x,y) ->x+y)); buda ayni sey oda calisir
        System.out.println(toplam);
    }

    public static void elemanToplama2(List<Integer> list) {
        Optional<Integer> toplam = list.stream().reduce(Math::addExact);
        // Optional<Integer> toplam=list.stream().reduce(Integer::sum);//integer classinda sum methodu ile topla diyoruz
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

        int carp2 = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> x * y);
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
        //noktasi olan x degerinden itibaren kıyaslayarak minumum degeri bul. Baslangic degerini MAX.VALUE yapmamizin nedenide;
        //x in en buyuk degerin den kucuk olacak.Yani ilk kiyasmalama degerimiz en buyuk sayi, ondan kucuklari bulacaz.
        //en buyugu bulmak isteseydik INTEGER.MINVALUE kullanmaliydik.
        System.out.println(enKucuk);
  }
  public static int minbulMethod(int x, int y){//sana  ye degerlerini gonderecem onlari kıyasla en kucuk olanı getir

        return x<y ? x : y;
  }

   public static void farklari(List<Integer> list){

       Integer farklari = list.stream().reduce(0, (x, y) -> x-y);
       System.out.println(farklari);
   }

    //List'teki 15'ten buyuk en kucvuk tek sayiyi yazdiriniz
    public static void onbestenBykKckTekSayi(List<Integer> list) {
        // list.stream().filter(t->t % 2 == 1).filter(t-> t>15).reduce(Integer::min);
        System.out.println(list.
                stream().//akısa girdi
                        filter(t -> t % 2 == 1 & t > 15).//tek ve 15 den byk sarti
                        reduce(Integer::min));//min deger reduce edildi
    }
    //list'in cift  elemanlarinin kareleri ni  kucuge buykten yazdiriniz
    public static void ciftKareKckByg(List<Integer> list){
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().//akısa giren elelmanlar naturel order'e gore siralanir
                forEach(Lambda01::printEl);//144 484 1156 1764 3600

    }
    //list'in tek  elemanlarinin kareleri ni buykten kucuge  yazdiriniz

    public static void tekKareBygKck(List<Integer> list){
        list.
                stream().
                filter(t->t%2!=0).
                map(t->t*t).
                sorted(Comparator.reverseOrder()).//akısa giren elelmanlar ters siralanir
                forEach(Lambda01::printEl);//144 484 1156 1764 3600
}}