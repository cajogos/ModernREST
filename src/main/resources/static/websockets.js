document.addEventListener('DOMContentLoaded', () => {
    /**
     * Messages area
     * @type {HTMLTextAreaElement}
     */
    const textArea = document.getElementById('messages');

    /**
     * Input Box
     * @type {HTMLInputElement}
     */
    const inputText = document.getElementById('message-input');

    /**
     * Send Button
     * @type {HTMLButtonElement}
     */
    const sendButton = document.getElementById('btn-send');

    sendButton.addEventListener('click', (event) => {
        let message = inputText.value.trim();
        if (message !== '') {
            socket.send(message);
        }
        inputText.value = '';
    });

    // Convert to correct endpoint
    let webSocketEndpoint = new URL(window.location);
    webSocketEndpoint.pathname = 'websocket';
    webSocketEndpoint.protocol = 'ws:';

    /**
     * The websocket object connection
     * @type {WebSocket}
     */
    const socket = new WebSocket(webSocketEndpoint.toString());

    socket.addEventListener('open', (event) => {
        socket.send('Connection!');
    });

    socket.addEventListener('message', (event) => {
        textArea.value += event.data + "\n";
    });
});