FROM node:15-alpine

WORKDIR /app

COPY . .

RUN npm install

EXPOSE 4001
CMD [ "node", "index.js" ]