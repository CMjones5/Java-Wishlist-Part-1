You're going to create a wishlist of all of your favorite products on the internet.

## Getting Started

```no-highlight
et get java-wishlist-part-i
cd java-wishlist-part-i
idea .
```

## Core User Stories

### Add a Product

```no-highlight
As a wish list maintainer
I want to add a product
So that I can keep track of the items I want
```

Acceptance Criteria:

- I have an option on a main menu to add a product to my wish list
- I want to persist the name, price, and URL of the product
- The item should be saved in the database

### List Products in my Wish List

```no-highlight
As a wish list maintainer
I want to list all of the products in my wish list
So that I can remember all the items I added
```

Acceptance Criteria:

- I have an option on a main menu to list all of my products on my wish list
- Items added are ordered by name in ascending order
- I can see the name, price, and URL for each product

### Categorize a Product

```no-highlight
As a wish list maintainer
I want to categorize my products
So that I can remember why I want them
```

Acceptance Criteria:

- When adding a product, I can optionally supply a category name
- If I supply a category name, the category is persisted to the database
- The category name should not be duplicated in the database
- When listing out my products, the category name is displayed along with each product

Implementation Details:

- Normalize the category in a separate table, and relate your products to those categories
- Ensure no duplicate category names are inserted into the category table

*It's recommended you read through the material on associations before tackling this user story.*

## Non-Core User Stories

### Delete a Product

```no-highlight
As a wish list maintainer
I want to delete a product
So that I can remove it when I've purchased it
```

Acceptance Criteria:

- I have an option on the main menu to delete a product
- When I select the option, I'm given a numbered list of products to delete
- I can enter a number and the product correlating to that number is deleted from the database

### Delete a Category

```no-highlight
As a wish list maintainer
I want to delete a category
So that I no longer associate products with that category
```

Acceptance Criteria:

- I have an option on the main menu to delete a category
- When I select the option, I'm given a numbered list of categories to delete
- I can enter a number and the category correlating to that number is deleted from the database
- All product relationships with that category are removed
