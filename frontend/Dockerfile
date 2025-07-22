# Étape 1 : Build Angular
FROM node:20-alpine AS builder
WORKDIR /app

# Copier package.json et installer les dépendances
COPY package*.json ./
RUN npm install

# Copier le reste du code source
COPY . .

# Build en mode production
RUN npm run build --prod

# Étape 2 : Servir avec NGINX
FROM nginx:alpine
COPY --from=builder /app/dist/frontend /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
