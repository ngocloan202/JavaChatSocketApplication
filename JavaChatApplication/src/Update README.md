# JavaChatSocketApplication

🚀 How to Run
### Method 1 ###
- We can easily launch the application using the JAR file.
1. Follow the path below: JavaChatApplication/src/production/....
2. Click on these two files to launch the Client and Server interfaces.
3. Then, proceed to exchange messages between the Client and Server.

### Method 2 ###
1. Set up the server
Open the FrChatServer.java file.
Run this file: The server listens for incoming client connections on a specified port.
By default, the server listens on port 8888

2. Set up the client
Open the FrChatClient.java file.
Run this file: After starting the server, run the client. The client will connect to the server (by default to localhost on port 8888)

3. Chat between client and server
Once both the server and client are running, you can start sending and receiving messages.
Type your message in the input box in the client, click Send, and the server will display the received message.
The server can also send messages back to the client.

💡 Features
- Real-time messaging: Messages are instantly exchanged between the server and the client.
- File sharing: The client and server can send file to each other during the session.
- Simple socket communication: Built using Java socket programming for client-server interaction.
- Console-based interaction: The server and client interact through a simple console-like interface.

🛠️ Technologies Used
- Java Sockets: For network communication between the server and client.
- Swing: For a basic graphical user interface (GUI) in the client (if implemented).
- Java I/O: To handle input/output between the server and client.
