import java.util.Scanner;


public class App {

	public static void main(String[] args) {

		Album a = new Album("cartoon characters", "images.txt");

		int option = -1;

		while (option != 0) {	
			option = showMenu();

			if (option == 1) {
				listAllPhotos(a);
			}
			else if (option == 2) {
				viewPhoto(a);
			}
			else if (option == 3) {
				removePhoto(a);
			}
      else if (option == 4) {
        editPhotoDescription(a);
      }
			else if (option != 0) {
				System.out.println("Invalid option");
			}

		}
		System.out.println("Good bye!");
	}

	public static int showMenu() {
		System.out.println("1: List all photos\n" + 
				"2: View a photo\n" + 
				"3: Remove a photo\n"+
        "4: Edit photo description\n" +
				"0: Exit");
		System.out.print("Choose an option: ");
		Scanner in = new Scanner(System.in);
		return in.nextInt(); 
	}


	private static void listAllPhotos(Album a) {
		for (Photo p : a.getPhotos()) {
			System.out.println(p);
		}
	}

	private static void viewPhoto(Album a) {
		for (int i = 0; i < a.getNumPhotos(); i++) {
			System.out.println((i+1) + ": " + a.getDescription(i));
		}
		System.out.print("Enter number: ");
		Scanner in = new Scanner(System.in);

		int choice = in.nextInt();
		if (choice <= 0 || choice > a.getNumPhotos()) {
			System.out.println("Invalid selection");
		}
		else {
			showPhoto(a.getFilename(choice-1));
		}
	}


	private static void removePhoto(Album a) {
		if (a.getNumPhotos() == 0) {
		System.out.println("The album is empty.");
		return;
		}

		for (int i = 0; i < a.getNumPhotos(); i++) {
		System.out.println((i+1) + ": " + a.getDescription(i));
		}

		System.out.print("Enter number of photo to remove: ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		if (choice <= 0 || choice > a.getNumPhotos()) {
		System.out.println("Invalid selection");
		return;
		}

		String desc = a.getDescription(choice - 1);
		System.out.print("Are you sure you want to remove \"" + desc + "\"? (y/n): ");
		Scanner confirmIn = new Scanner(System.in);
		String confirm = confirmIn.next();
		if (confirm.equalsIgnoreCase("y")) {
			boolean removed = a.removePhoto(choice - 1);
			if (removed) {
				System.out.println("Photo removed.");
			}
			else {
				System.out.println("Error removing photo.");
			}
		}
		else {
		System.out.println("Removal cancelled.");
		}
	}

  private static void editPhotoDescription(Album a) {
    if (a.getNumPhotos() == 0) {
      System.out.println("The album is empty.");
      return;
    }

    for (int i = 0; i < a.getNumPhotos(); i++) {
      System.out.println((i + 1) + ": " + a.getDescription(i));
    }

    System.out.print("Enter number of photo to edit: ");
    Scanner in = new Scanner(System.in);
    int choice = in.nextInt();
    in.nextLine();

    if (choice <= 0 || choice > a.getNumPhotos()) {
      System.out.println("Invalid selection");
      return;
    }

    System.out.print("Enter new description: ");
    String newDescription = in.nextLine();

    boolean edited = a.editPhotoDescription(choice - 1, newDescription);

    if (edited) {
      System.out.println("Photo description updated.");
    }
    else {
      System.out.println("Error updating photo description.");
    }
  }

	/*
	 * This method can be used to show a single photo.
	 */
	private static void showPhoto(String filename) {
		try {
			StdDraw.picture(0.5, 0.5, filename, 0.8, 0.8);
			Thread.sleep(1000);
		}
		catch (IllegalArgumentException e) {
			System.out.println("ERROR: image [" + filename + "] not found");
		} 
		catch (InterruptedException e) {
		}
	}


}
