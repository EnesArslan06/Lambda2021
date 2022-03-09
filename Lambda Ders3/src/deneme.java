import java.util.Scanner;

public class deneme<yedek> {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int sayi = scan.nextInt();
        int yedek=sayi;
        int carpilacak=0;
        int x=0;


        while(sayi>0){

            carpilacak=sayi%10;
            x+=carpilacak*carpilacak*carpilacak;
            sayi=sayi/10;
        }


    if (x==yedek){
        System.out.println(yedek + " Amstrog sayi");
    }
        else {
        System.out.println(yedek+ " Amstrog degil");
    }

    }




    }

