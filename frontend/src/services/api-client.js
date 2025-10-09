export class ApiClient {
    constructor(base) {
        this.base = base.replace(/\/$/, '');
    }

    async get(path)  { return this._send(path, 'GET'); }
    async post(path, body) { return this._send(path, 'POST', body); }

    async _send(path, method, body) {
        const res = await fetch(`${this.base}${path}`, {
            method,
            headers: { 'Content-Type': 'application/json' },
            body: body ? JSON.stringify(body) : undefined
        });

        // if server return not JSON (foe example 404.html) – not falling!
        if (!res.ok) throw new Error(`${res.status} ${res.statusText}`);

        // parse JSON if have body
        const text = await res.text();
        return text ? JSON.parse(text) : {};
    }
}