import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="categories", uniqueConstraints = {@UniqueConstraint(columnNames="id")})
public class Category {

  @Id
  @SequenceGenerator(name = "category_generator", sequenceName = "categories_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
  @Column(name = "id", nullable = false, unique = true)
  private long id;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @OneToMany(mappedBy = "category")
  private List<Product> products = new ArrayList<Product>();

  public List<Product> getProducts() {
    return products;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }




}