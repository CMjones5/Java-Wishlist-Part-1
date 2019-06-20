import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class MainMenu {

  private static final String ADD_OPTION = "Add a product to the wishlist.";
  private static final String EXIT_MENU = "Exit the menu.";
  private static final String OUTPUT_MENU = "List my Products";
  private static List<String> optionsList = new ArrayList<String>();
  private static Scanner reader = new Scanner(System.in);

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.java_wishlist");
  private static EntityManager em = emf.createEntityManager();

  private static void addProduct() {
    System.out.println("Enter product name:");
    String productName = reader.nextLine();
    System.out.println("Enter product price:");
    Double productPrice = Double.parseDouble(reader.nextLine());
    System.out.println("Enter product url:");
    String productUrl = reader.nextLine();
    System.out.println("Type in either the category name or 'no'");
    String productCategory = reader.nextLine();

    TypedQuery<String> queryCategoryNames = em.createQuery("SELECT c FROM Category c WHERE c.name = " + productCategory, String.class);
    List<String> categoryNames = queryCategoryNames.getResultList();

    if (categoryNames.size() > 0) {
      // this categoryName already exists
    }
    
    if (productCategory.equals("no")) {
      productCategory = "None";
    }

    Product newProduct = new Product();
    Category newCategory = new Category();
    newCategory.setName(productCategory);
    newProduct.setName(productName);
    newProduct.setPrice(productPrice);
    newProduct.setUrl(productUrl);
    newProduct.setCategory(newCategory);

    try {
      em.getTransaction().begin();
      em.persist(newCategory);
      em.getTransaction().commit();

      em.getTransaction().begin();
      em.persist(newProduct);
      em.getTransaction().commit();

    } finally {
      em.close();
      emf.close();
    }

  }

  private static void listProduct() {
    TypedQuery<Product>query = em.createQuery("SELECT p FROM Product p ORDER BY p.name", Product.class);
    List<Product>products = query.getResultList();
    for(Product product : products){
      System.out.println("name: " + product.getName() + " price: " + product.getPrice() + " URL: " + product.getUrl());

    }

  }

  public static void main(String[] args) {
    System.out.println("Please choose the option you'd like to choose...");
    optionsList.add(ADD_OPTION);
    optionsList.add(OUTPUT_MENU);
    int counter = 1;
    for(String option : optionsList){
      System.out.println(counter + ". " + option);
      counter++;

    }
    System.out.println(counter + ". " + EXIT_MENU);
    int userInput = reader.nextInt();
    reader.nextLine();
    if (userInput == 1) {
      addProduct();
    }else if(userInput == 2){
      listProduct();
    }




  }




}
