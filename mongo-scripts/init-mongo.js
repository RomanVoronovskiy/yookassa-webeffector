db.createUser(
    {
        user: "usrDev",
        pwd: "pasDev",
        roles: [
            {
                role: "readWrite",
                db: "yookassa"
            }
        ]
    }
);
// Создание коллекции status_info
db.createCollection("status_info");

// Создание коллекции payment_info
db.createCollection("payment_info");
