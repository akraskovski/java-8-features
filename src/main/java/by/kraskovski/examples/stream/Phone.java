package by.kraskovski.examples.stream;

import java.util.List;
import java.util.Objects;

public class Phone {

    private String name;
    private int price;
    private List<String> manufactures;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getManufactures() {
        return manufactures;
    }

    public static Builder builder() {
        return new Phone().new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return price == phone.price &&
                Objects.equals(name, phone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public class Builder {

        private Builder() {
        }

        public Builder setName(final String name) {
            Phone.this.name = name;
            return this;
        }

        public Builder setPrice(final int price) {
            Phone.this.price = price;
            return this;
        }

        public Builder setManufactures(final List<String> manufactures) {
            Phone.this.manufactures = manufactures;
            return this;
        }

        public Phone build() {
            return Phone.this;
        }
    }
}
