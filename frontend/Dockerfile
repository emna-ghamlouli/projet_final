# Étape 1 : Build de l'application Angular
FROM node:20-alpine AS builder
WORKDIR /app

# Copier les fichiers Angular
COPY . .

# Installer les dépendances et construire le projet
RUN npm install && npm run build --prod

# Étape 2 : Serveur NGINX pour servir l'app
FROM nginx:alpine
COPY --from=builder /app/dist/ /usr/share/nginx/html

# Copier un fichier de config NGINX personnalisé (facultatif)
# COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

