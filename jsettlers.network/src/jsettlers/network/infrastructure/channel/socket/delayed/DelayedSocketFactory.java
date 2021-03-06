package jsettlers.network.infrastructure.channel.socket.delayed;

import java.io.IOException;
import java.net.Socket;

import jsettlers.network.infrastructure.channel.socket.ISocket;
import jsettlers.network.infrastructure.channel.socket.ISocketFactory;
import jsettlers.network.infrastructure.channel.socket.SocketConnectException;

/**
 * Factory class to create {@link DelayedSocket}s.
 * 
 * @author Andreas Eberle
 * 
 */
public class DelayedSocketFactory implements ISocketFactory {

	@Override
	public ISocket generateSocket(String host, int port) throws SocketConnectException {
		try {
			return new DelayedSocket(new Socket(host, port));
		} catch (IOException e) {
			e.printStackTrace();
			throw new SocketConnectException("Error during socket connection");
		}
	}

	@Override
	public ISocket generateSocket(Socket socket) throws SocketConnectException {
		try {
			return new DelayedSocket(socket);
		} catch (IOException e) {
			e.printStackTrace();
			throw new SocketConnectException("Error during socket connection");
		}
	}

}
