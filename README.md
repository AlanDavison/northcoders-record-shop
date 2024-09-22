# Northcoders Record Shop Backend API
This is the backend API for the Android frontend.

## How to run
* Clone the repo
* Refresh the Maven dependencies
* Tweak the `application*.properties` files in `src/main/resources` as appropriate for your use-case, noting that `application-prod.properties` is gitignored.

## How to populate the database
There's an `api/v1/records/many` endpoint you can use to POST an array of `Album` objects to populate the database in one go. The nested `Artist` objects within the `Album` objects will be automatically inserted appropriately.

## Endpoints

All endpoints return either an `Album` JSON object, an `Artist` JSON objects, or an array of either. Model details are below.

### GET `/api/v1/recordshop/records`
> Returns every `Album` in the database as an array of JSON objects.

### GET `/api/v1/recordshop/records/<record_id>`
> Return the `Album` with the specified `long` ID.

### GET `/api/v1/recordshop/artists`
> Returns every `Artist` in the database as an array of JSON objects.

### GET `/api/v1/recordshop/artists/<artist_id>`
> Return the `Artist` with the specified `long` ID.

### PATCH `/api/v1/recordshop/records/<record_id>`
> Updates the `Album` with the specified ID. Request body takes a single JSON object specifying only the fields to be changed.

### POST `/api/v1/recordshop/records`
> Add an `Album` to the database. Request body takes a single JSON object, with every field minus the ID being mandatory.

### POST `/api/v1/recordshop/records/many`
> The same as above, but the body should be an array of JSON objects.

### POST `/api/v1/recordshop/artists`
> Add an `Artist` to the database. Request body takes a single JSON object, with every field minus the ID being mandatory.

### POST `/api/v1/recordshop/artists/many`
> The same as above, but the body should be an array of JSON objects.

## Request/response models

### Album
```json
{
    "artists": [
      {
        "name": "Jethro Tull",
        "portraitImageUrl": "https://image/url/image.jpeg"
      }
    ],
    "name": "Aqualung",
    "description": "Significantly more wholesome than it seems at first.",
    "albumArtUrl": "https://image/url/image.jpeg",
    "genre": 4,
    "type": 1,
    "stockCount": 200,
    "cost": 16.00
}
```

### Artist
```json
{
  "name": "Jethro Tull",
  "portraitImageUrl": "https://image/url/image.jpeg"
}
```