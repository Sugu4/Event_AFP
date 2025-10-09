import {ApiClient} from './services/api-client.js';
import {EventController} from './controllers/event-controller.js';
import {EventView} from './views/event-view.js';

const api = new ApiClient('http://127.0.0.1:3001'); // live-server
await api.get('/events.json');
const view = new EventView(document.body);
const ctrl = new EventController(api, view);

ctrl.loadEvents().catch(console.error);