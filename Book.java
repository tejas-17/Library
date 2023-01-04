
public class Book {
	//aish
    private String id;
    private String title;
    private String author;
    private String publishYear;
    private String quantity;
    private String status;
    private String borrowed;
    private String cost;
    
    
    public Book() {
    	System.out.println("no values given");
    }

    
      public Book(String id, String title, String author, String publishYear, String quantity, String status,
			String borrowed, String cost) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;
		this.quantity = quantity;
		this.status = status;
		this.borrowed = borrowed;
		this.cost = cost;
	}


	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
    
    public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(String borrowed) {
		this.borrowed = borrowed;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishYear=" + publishYear
				+ ", quantity=" + quantity + ", status=" + status + ", borrowed=" + borrowed + ", cost=" + cost + "]";
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}

}
