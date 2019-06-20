import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="products", uniqueConstraints = {@UniqueConstraint(columnNames="id")})
public class Product {
  @Id
  @SequenceGenerator(name = "product_generator", sequenceName = "products_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
  @Column(name = "id", nullable = false, unique = true)
  private long id;

  @Column(name="name", nullable = false, length = 50)
  private String name;

  @Column(name="price", nullable = false)
  private double price;

  @Column(name="url", nullable = false)
  private String url;

//  @Column(name="category_id", insertable = false, updatable = false)
//  private long category_id;
  // the same as the below defined category_id

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

//  public long getCategory_id() {
//    return category_id;
//  }
//
//  public void setCategory_id(long category_id) {
//    this.category_id = category_id;
//  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
