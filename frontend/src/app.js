import {ApiClient} from "./services/api-client";
import {EventController} from "./controllers/event-controller";
import {EventView} from "./views/event-view";

const api = new ApiClient('http://localhost:8080/api/v1/');
const view = new EventView(document.body);
const ctrl = new EventController(view, api);
ctrl.loadEvents();