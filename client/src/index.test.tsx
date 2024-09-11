// index.test.tsx

import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect'; // Import for additional matchers
import { App } from './index';  // Import App component directly

describe('Message Board App', () => {
  beforeEach(() => {
    // Mock the global fetch API to avoid real network requests
    global.fetch = jest.fn(() =>
      Promise.resolve({
        json: () => Promise.resolve([
          { ID: 1, NAME: JSON.stringify({ name: 'Test message 1' }) },
          { ID: 2, NAME: JSON.stringify({ name: 'Test message 2' }) }
        ]),
      })
    ) as jest.Mock;
  });

  afterEach(() => {
    jest.restoreAllMocks(); // Clean up after each test
  });

  it('renders without crashing', () => {
    render(<App />);
  });

  it('displays messages fetched from the server', async () => {
    render(<App />);
    
    // Check if both messages are in the document
    expect(await screen.findByText('Test message 1')).toBeInTheDocument();
    expect(await screen.findByText('Test message 2')).toBeInTheDocument();
  });

  it('displays the "Add Message" button', () => {
    render(<App />);
    expect(screen.getByText('Add Message')).toBeInTheDocument();
  });

  it('can add a new message', async () => {
    render(<App />);

    // Mock the POST request for adding a message
    global.fetch = jest.fn(() =>
      Promise.resolve({
        json: () => Promise.resolve({}),
      })
    ) as jest.Mock;

    // Type a new message
    fireEvent.change(screen.getByLabelText('New Message'), { target: { value: 'New test message' } });

    // Click on the "Add Message" button
    fireEvent.click(screen.getByText('Add Message'));

    // Check if the fetch function was called for the POST request
    expect(global.fetch).toHaveBeenCalledTimes(1); // One for GET and one for POST
  });
});
