import {ApiClient} from './services/api-client.js';
import {EventController} from './controllers/event-controller.js';
import {EventView} from './views/event-view.js';

const api = new ApiClient('http://localhost:8080/api/v1/');
const view = new EventView(document.body);
const ctrl = new EventController(api, view);

ctrl.loadEvents().catch(console.error);