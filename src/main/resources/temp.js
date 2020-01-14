class Utils {

}

// IndexDB数据库操作方法
Utils.IndexDBUtil = class DataBaseUtil {

    /**
     * 返回一个数据库连接对象
     * @param databaseName 字符串，表示数据库的名字。如果指定的数据库不存在，就会新建数据库
     * @param version 整数，表示数据库的版本。如果省略，打开已有数据库时，默认为当前版本；新建数据库时，默认为1
     */
    constructor(databaseName, version = 1) {
        let request = window.indexedDB.open(databaseName, version);
        // 数据库打开成功
        request.onsuccess = event => {
            this.db = request.result;
            console.log('数据库打开成功');
        };
        // 数据库更新成功
        request.onupgradeneeded = event => {
            this.db = event.target.result;
        };
        // 数据库打开失败
        request.onerror = event => {
            console.log('数据库打开报错');
        };
    }

    createTable(tableName, primaryKeyName) {
        if (!this.db) throw new Error("在createTable之前请使用Utils.IndexDBUtil.openDBConnection打开一个数据库");
        this.tableName = tableName;
        if (!this.db.objectStoreNames.contains(tableName)) {
            this.objectStore = this.db.createObjectStore(
                tableName,
                {
                    keyPath: primaryKeyName,
                    autoIncrement: !primaryKeyName
                }
            );
        }
    }

    createIndex(indexName, indexProperty, indexConstraint) {
        if (!this.objectStore) throw new Error("在createIndex之前请使用createTable创建一个表");
        this.objectStore.createIndex(indexName, indexProperty, indexConstraint);
    }

    insert(object) {
        if (!this.db) throw new Error("请先使用Utils.IndexDBUtil.openDBConnection打开一个数据库");
        if (!this.objectStore) throw new Error("在insert之前请使用createTable创建一个表");
        var request = this.db.transaction([this.tableName], 'readwrite')
            .objectStore(this.tableName)
            .add(object);
        request.onsuccess = function (event) {
            console.log('数据写入成功');
        };
        request.onerror = function (event) {
            console.log('数据写入失败');
        }
    }

    update(primaryKey, object) {

    }

    updateWithCondition(conditionObject, object) {

    }

    remove() {

    }

    queryAll() {

    }

    queryWithCondition() {

    }

    queryById() {

    }
};

//打开IndexDB数据库连接
Utils.IndexDBUtil.openDBConnection = (databaseName, version = 1) => new Utils.IndexDBUtil(databaseName, version);