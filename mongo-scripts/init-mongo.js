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
db.createCollection("status_info");

db.createCollection("payment_info");
