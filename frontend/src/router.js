
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OderOrderManager from "./components/listers/OderOrderCards"
import OderOrderDetail from "./components/listers/OderOrderDetail"

import DeliveryDeliveryManager from "./components/listers/DeliveryDeliveryCards"
import DeliveryDeliveryDetail from "./components/listers/DeliveryDeliveryDetail"

import InventoryInventoryManager from "./components/listers/InventoryInventoryCards"
import InventoryInventoryDetail from "./components/listers/InventoryInventoryDetail"

import NotificationNotifyManager from "./components/listers/NotificationNotifyCards"
import NotificationNotifyDetail from "./components/listers/NotificationNotifyDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/oders/orders',
                name: 'OderOrderManager',
                component: OderOrderManager
            },
            {
                path: '/oders/orders/:id',
                name: 'OderOrderDetail',
                component: OderOrderDetail
            },

            {
                path: '/deliveries/deliveries',
                name: 'DeliveryDeliveryManager',
                component: DeliveryDeliveryManager
            },
            {
                path: '/deliveries/deliveries/:id',
                name: 'DeliveryDeliveryDetail',
                component: DeliveryDeliveryDetail
            },

            {
                path: '/inventories/inventories',
                name: 'InventoryInventoryManager',
                component: InventoryInventoryManager
            },
            {
                path: '/inventories/inventories/:id',
                name: 'InventoryInventoryDetail',
                component: InventoryInventoryDetail
            },

            {
                path: '/notifications/notifies',
                name: 'NotificationNotifyManager',
                component: NotificationNotifyManager
            },
            {
                path: '/notifications/notifies/:id',
                name: 'NotificationNotifyDetail',
                component: NotificationNotifyDetail
            },




    ]
})
