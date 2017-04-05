Before runing the examples:
1) Install PostgreSQL and create database "test".
1) Open command propmpt and go to "database" directory.
1) Check that credentials in build.gradle match your local credentials.
1) Initilaize Flyway tables in database: `gradle flywayBaseline`.
1) Migrate database: `gradle flywayMigrate`
Database is now ready for use.