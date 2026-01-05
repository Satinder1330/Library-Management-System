
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){

            System.out.println("\n-WELCOME TO KNOWLEDGE LIBRARY-");
            System.out.println("PRESS 1 TO LOGIN AS LIBRARIAN");
            System.out.println("PRESS 2 TO LOGIN AS A MEMBER ");
            System.out.println("PRESS 3 FOR JUST SEARCH A BOOK ");
            System.out.println("PRESS 4 FOR EXIT ");
            int ch1= input.nextInt();
            input.nextLine();
            if(ch1==1){
                while (true) {
                    librarian();
                    int ch2 = input.nextInt();
                    input.nextLine();
                    switch (ch2) {
                        case 1 -> Librarian.addBook();
                        case 2 -> Librarian.deleteBook();
                        case 3 -> Members.searchBook();
                        case 4 -> Librarian.viewBooks();
                        case 5 -> Librarian.addMember();
                        case 6 -> Librarian.deleteMember();
                        case 7 -> Librarian.viewMembers();
                        case 8 -> {
                            return;
                        }
                    }
                }
            }if(ch1==2){
                while (true) {
                    member();
                    int ch3 = input.nextInt();
                    input.nextLine();
                    switch (ch3) {
                        case 1 -> {
                            System.out.println("ENTER YOUR MEMBER ID");
                        int id = input.nextInt();
                        Members.rentBook(id);}
                        case 2 -> Members.returnBook();
                        case 3 -> Librarian.viewBooks();
                        case 4 ->Members.searchBook();
                        case 5 -> Members.memberId();
                        case 6 -> Members.viewRentals();
                        case 7 -> {
                            return;
                        }
                    }
                }
            }if (ch1==3){
                Members.searchBook();
            }if (ch1==4){
                System.exit(0);
            }
        }

    }
    public static void librarian(){
        System.out.println("\n -LIBRARIAN MENU-");
        System.out.println("PRESS 1 -- ADD BOOK");
        System.out.println("PRESS 2 -- DELETE BOOK");
        System.out.println("PRESS 3 -- SEARCH BOOK");
        System.out.println("PRESS 4 -- VIEW ALL BOOKS");
        System.out.println("PRESS 5 -- ADD MEMBER");
        System.out.println("PRESS 6 -- DELETE MEMBER");
        System.out.println("PRESS 7 -- VIEW ALL MEMBERS");
        System.out.println("PRESS 8 -- EXIT");
    }
    public static void member(){
        System.out.println("\n -MEMBERS MENU-");
        System.out.println("PRESS 1 -- BORROW BOOK");
        System.out.println("PRESS 2 -- RETURN BOOK");
        System.out.println("PRESS 3 -- VIEW ALL BOOKS");
        System.out.println("PRESS 4 -- CHECK AVAILABILITY OF THE BOOK");
        System.out.println("PRESS 5 -- TO KNOW YOUR MEMBER ID");
        System.out.println("PRESS 6 -- VIEW ALL RENTALS");
        System.out.println("PRESS 7 -- EXIT");
    }
}