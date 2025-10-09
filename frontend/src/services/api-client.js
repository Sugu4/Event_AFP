export class ApiClient {
    constructor(base) {
        this.base = base;
    }

    async get(path) {
        return this._send(path, 'GET');
    }

    async post(path, body) {
        return this._send(path, 'POST', body);
    }
    async _send(path, method, body) {
        const response = await fetch(`${this.base}${path}`, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: body ? JSON.stringify(body) : undefined
        });
        return response.json();
    }
}