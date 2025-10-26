EatExpress

## Why Node?

NodeJS is not a dependency. It's used strictly only for improving developer experience like formatting.

## Install

### Keycloak

#### Roles
- Realm roles -> Create role
  - name: restaurant-owner
  - desc: ${role_restaurant-owner}
- In realm roles open default-roles-my-realm. Assign realm role you've just created.
- Refetch access token

## Development

`nvm install`
`npm run dev`

### Watch for changes & reload

In separate terminal run also:

`npm run watch`
