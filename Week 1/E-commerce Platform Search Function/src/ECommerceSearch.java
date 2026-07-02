class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class ECommerceSearch {

    // Linear Search
    static void linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) {
                System.out.println("Linear Search: Product Found - " + p.productName);
                return;
            }
        }
        System.out.println("Linear Search: Product Not Found");
    }

    // Binary Search
    static void binarySearch(Product[] products, int id) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                System.out.println("Binary Search: Product Found - " + products[mid].productName);
                return;
            } else if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Search: Product Not Found");
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "PowerDrill", "Tools"),
            new Product(102, "JDK Book", "Book"),
            new Product(103, "Headphone", "Accessories"),
            new Product(104, "Laptop", "Eletronics"),
            new Product(105, "Mouse", "Accessories")
        };

        int searchId = 104;

        linearSearch(products, searchId);
        binarySearch(products, searchId);

        System.out.println("\nTime Complexity:");
        System.out.println("Linear Search  : O(n)");
        System.out.println("Binary Search  : O(log n)");
    }
}