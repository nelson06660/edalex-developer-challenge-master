import * as React from 'react';
import * as ReactDOM from 'react-dom';
import {
    Container, TextField, Button, List, ListItem,
    ListItemText, IconButton, Dialog, DialogTitle,
    DialogContent, DialogActions, Typography
} from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import { useState, useEffect } from 'react';

export const App = () => {
    const [messages, setMessages] = useState<any[]>([]);
    const [newMessage, setNewMessage] = useState<string>('');
    const [selectedMessage, setSelectedMessage] = useState<any | null>(null);
    const [dialogOpen, setDialogOpen] = useState<boolean>(false);

    useEffect(() => {
        fetchMessages();
    }, []);

    const fetchMessages = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/message');
            const data = await response.json();
            const parsedData = data.map((message: any) => ({
                ...message,
                NAME: JSON.parse(message.NAME)
            }));
            setMessages(parsedData);
        } catch (error) {
            console.error('Error fetching messages:', error);
        }
    };

    const addMessage = async () => {
        try {
            await fetch('http://localhost:8080/api/message', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ name: newMessage })
            });
            setNewMessage('');
            fetchMessages();
        } catch (error) {
            console.error('Error adding message:', error);
        }
    };

    const removeMessage = async (id: number) => {
        try {
            await fetch(`http://localhost:8080/api/message/${id}`, { method: 'DELETE' });
            fetchMessages();
        } catch (error) {
            console.error('Error removing message:', error);
        }
    };

    const openDialog = (message: any) => {
        setSelectedMessage(message);
        setDialogOpen(true);
    };

    const closeDialog = () => {
        setDialogOpen(false);
        setSelectedMessage(null);
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>Message Board</Typography>
            <TextField
                label="New Message"
                value={newMessage}
                onChange={(e) => setNewMessage(e.target.value)}
                fullWidth
                margin="normal"
            />
            <Button variant="contained" color="primary" onClick={addMessage}>Add Message</Button>
            <List>
                {messages.length === 0 ? (<Typography>No messages available</Typography>) :
                 (
                    messages.map((message: any) => (
                        <ListItem key={message.ID}>
                            <ListItemText primary={message.NAME.name} />
                            <IconButton edge="end" aria-label="delete" onClick={() => removeMessage(message.ID)}>
                                <DeleteIcon />
                            </IconButton>
                            <Button onClick={() => openDialog(message)}>View</Button>
                        </ListItem>
                    ))
                )}
            </List>
            <Dialog open={dialogOpen} onClose={closeDialog}>
                <DialogTitle>Message Details</DialogTitle>
                <DialogContent>
                    <Typography>{selectedMessage?.NAME.name}</Typography>
                </DialogContent>
                <DialogActions>
                    <Button onClick={closeDialog} color="primary">Close</Button>
                </DialogActions>
            </Dialog>
        </Container>
    );
};

// Temporary solution because im having problem with my test script
if (process.env.NODE_ENV !== 'test') {
    ReactDOM.render(<App />, document.getElementById('root'));
}
