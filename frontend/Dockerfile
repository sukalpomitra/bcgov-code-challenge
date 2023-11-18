# Use an official Node.js runtime as a parent image
FROM node:14

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install app dependencies
RUN npm install

# Copy the rest of your application code to the container
COPY . .

# Build the React app
RUN npm run build

# Install serve globally
RUN npm install -g serve

# Expose the port on which your React app runs (e.g., 3000)
EXPOSE 3000

# Define the command to start your React app
CMD ["serve", "-s", "build"]
