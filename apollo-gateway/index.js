require('dotenv').config()
const { ApolloServer } = require('apollo-server');
const { ApolloGateway } = require('@apollo/gateway');

const gateway = new ApolloGateway();
const server = new ApolloServer({ gateway, subscriptions:false, tracing:true });
server.listen();
