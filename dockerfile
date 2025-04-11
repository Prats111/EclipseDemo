# Use a base image with Java and Maven installed
FROM maven:3.8.1-openjdk-11-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Install any necessary dependencies
RUN mvn dependency:resolve

# Command to run your tests
CMD ["mvn", "test"]