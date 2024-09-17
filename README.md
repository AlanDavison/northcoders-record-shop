# Northcoders Record Shop Backend API
This is the backend API for the Android frontend.

## How to run
* Clone the repo
* Refresh the Maven dependencies
* Tweak the `application*.properties` files in `src/main/resources` as appropriate for your use-case, noting that `application-prod.properties` is gitignored.

## How to populate the database
There's an `api/v1/records/many` endpoint you can use to POST an array of `Album` objects to populate the database in one go. The nested `Artist` objects within the `Album` objects will be automatically inserted appropriately.