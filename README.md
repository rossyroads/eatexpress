EatExpress

## Install

### Keycloak

#### Roles
- Realm roles -> Create role
  - name: restaurant-owner
  - desc: ${role_restaurant-owner}
- In realm roles open default-roles-my-realm. Assign realm role you've just created.
- Refetch access token

---
## Development

`nvm install`
`npm i`
`npm run dev`

### Watch for changes & reload

In separate terminal run also:

`npm run watch`

---
## Challenges & Accomplishments

Describe:
- The most significant challenges you encountered during development.
- The aspects of your project you are most proud of.

---

## ✅ Finished Features

- [x] Creating restaurants
- [x] Limit one restaurant per account
- [x] Security of application with keycloak
- [x] Implemented role based security
- [x] Creating dishes for restaurant
- [x] Added pusblishing functionality for menu items
- [x] Added unpublishing functionality for menu items
- [x] Implemented message queue for dish events
- [x] Implemented getting coordinates of an address via geocode.maps.co API
- [x] Added exception responses
- [x] Added restaurant price range history tracking
- [x] Create order
- [x] Create order without account
- [x] And more in frontend..
---

## ❌ Unfinished / Planned Features

- [ ] Add editing of dishes
- [ ] Add scheduling applying changes of dishes
- [ ] Set dishes out/in stock
- [ ] Override restaurant opening time
- [ ] Accept/decline orders
- [ ] Track order progress as status changes
- [ ] Filter restaurants, dishes
- [ ] Adjust price range criteria
- [ ] And more in frontend..

## FAQ

### Why Node?

NodeJS is not a dependency. It's used strictly only for improving developer experience like formatting. Also it's a fun party trick.

### Why all the setters?

To simplify entity and dto mapping I decided to use org.mapstruct.Mapper which relies on all setters being present.

### Why RabbitMQ in dish controller?

Originally my idea was to implement Dish event sourced with message queues for different actions against Dishes. During implementation I pivoted to a DishAggregate with two DishDetails to simplify. RabbitMQ will be removed from Dishes in a future version.

### Where's DDD?

My use case implementations were feeling sad and empty.
