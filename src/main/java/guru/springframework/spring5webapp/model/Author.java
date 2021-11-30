package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long        id;

    public String       firstName;
    public String       lastaName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author()
    {
    }

    public Author(String firstName, String lastaName, Set<Book> books)
    {
        this.firstName = firstName;
        this.lastaName = lastaName;
        this.books = books;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastaName()
    {
        return lastaName;
    }

    public void setLastaName(String lastaName)
    {
        this.lastaName = lastaName;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }

    @Override
    public String toString()
    {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastaName='" + lastaName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }
}
