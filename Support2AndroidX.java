package support2AndroidX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * 
 * 吧项目中的Support 转成  AndroidX
 * 
 * @author Administrator
 *
 */
public class Support2AndroidX {

	// 2020-05-26的数据
	String jsonStr = "{\"android.arch.core.executor.AppToolkitTaskExecutor\":\"androidx.arch.core.executor.AppToolkitTaskExecutor\",\"android.arch.core.executor.ArchTaskExecutor\":\"androidx.arch.core.executor.ArchTaskExecutor\",\"android.arch.core.executor.DefaultTaskExecutor\":\"androidx.arch.core.executor.DefaultTaskExecutor\",\"android.arch.core.executor.JunitTaskExecutorRule\":\"androidx.arch.core.executor.JunitTaskExecutorRule\",\"android.arch.core.executor.TaskExecutor\":\"androidx.arch.core.executor.TaskExecutor\",\"android.arch.core.executor.TaskExecutorWithFakeMainThread\":\"androidx.arch.core.executor.TaskExecutorWithFakeMainThread\",\"android.arch.core.executor.testing.CountingTaskExecutorRule\":\"androidx.arch.core.executor.testing.CountingTaskExecutorRule\",\"android.arch.core.executor.testing.InstantTaskExecutorRule\":\"androidx.arch.core.executor.testing.InstantTaskExecutorRule\",\"android.arch.core.internal.FastSafeIterableMap\":\"androidx.arch.core.internal.FastSafeIterableMap\",\"android.arch.core.internal.SafeIterableMap\":\"androidx.arch.core.internal.SafeIterableMap\",\"android.arch.core.util.Function\":\"androidx.arch.core.util.Function\",\"android.arch.lifecycle.AndroidViewModel\":\"androidx.lifecycle.AndroidViewModel\",\"android.arch.lifecycle.ClassesInfoCache\":\"androidx.lifecycle.ClassesInfoCache\",\"android.arch.lifecycle.CompositeGeneratedAdaptersObserver\":\"androidx.lifecycle.CompositeGeneratedAdaptersObserver\",\"android.arch.lifecycle.ComputableLiveData\":\"androidx.lifecycle.ComputableLiveData\",\"android.arch.lifecycle.DefaultLifecycleObserver\":\"androidx.lifecycle.DefaultLifecycleObserver\",\"android.arch.lifecycle.Elements_extKt\":\"androidx.lifecycle.Elements_extKt\",\"android.arch.lifecycle.EmptyActivityLifecycleCallbacks\":\"androidx.lifecycle.EmptyActivityLifecycleCallbacks\",\"android.arch.lifecycle.ErrorMessages\":\"androidx.lifecycle.ErrorMessages\",\"android.arch.lifecycle.FullLifecycleObserver\":\"androidx.lifecycle.FullLifecycleObserver\",\"android.arch.lifecycle.FullLifecycleObserverAdapter\":\"androidx.lifecycle.FullLifecycleObserverAdapter\",\"android.arch.lifecycle.GeneratedAdapter\":\"androidx.lifecycle.GeneratedAdapter\",\"android.arch.lifecycle.GenericLifecycleObserver\":\"androidx.lifecycle.GenericLifecycleObserver\",\"android.arch.lifecycle.HolderFragment\":\"androidx.lifecycle.HolderFragment\",\"android.arch.lifecycle.Input_collectorKt\":\"androidx.lifecycle.Input_collectorKt\",\"android.arch.lifecycle.Lifecycle\":\"androidx.lifecycle.Lifecycle\",\"android.arch.lifecycle.LifecycleDispatcher\":\"androidx.lifecycle.LifecycleDispatcher\",\"android.arch.lifecycle.LifecycleObserver\":\"androidx.lifecycle.LifecycleObserver\",\"android.arch.lifecycle.LifecycleOwner\":\"androidx.lifecycle.LifecycleOwner\",\"android.arch.lifecycle.LifecycleProcessor\":\"androidx.lifecycle.LifecycleProcessor\",\"android.arch.lifecycle.LifecycleRegistry\":\"androidx.lifecycle.LifecycleRegistry\",\"android.arch.lifecycle.LifecycleRegistryOwner\":\"androidx.lifecycle.LifecycleRegistryOwner\",\"android.arch.lifecycle.LifecycleService\":\"androidx.lifecycle.LifecycleService\",\"android.arch.lifecycle.Lifecycling\":\"androidx.lifecycle.Lifecycling\",\"android.arch.lifecycle.LiveData\":\"androidx.lifecycle.LiveData\",\"android.arch.lifecycle.LiveDataReactiveStreams\":\"androidx.lifecycle.LiveDataReactiveStreams\",\"android.arch.lifecycle.MediatorLiveData\":\"androidx.lifecycle.MediatorLiveData\",\"android.arch.lifecycle.MethodCallsLogger\":\"androidx.lifecycle.MethodCallsLogger\",\"android.arch.lifecycle.model.AdapterClass\":\"androidx.lifecycle.model.AdapterClass\",\"android.arch.lifecycle.model.AdapterClassKt\":\"androidx.lifecycle.model.AdapterClassKt\",\"android.arch.lifecycle.model.EventMethod\":\"androidx.lifecycle.model.EventMethod\",\"android.arch.lifecycle.model.EventMethodCall\":\"androidx.lifecycle.model.EventMethodCall\",\"android.arch.lifecycle.model.InputModel\":\"androidx.lifecycle.model.InputModel\",\"android.arch.lifecycle.model.LifecycleObserverInfo\":\"androidx.lifecycle.model.LifecycleObserverInfo\",\"android.arch.lifecycle.MutableLiveData\":\"androidx.lifecycle.MutableLiveData\",\"android.arch.lifecycle.Observer\":\"androidx.lifecycle.Observer\",\"android.arch.lifecycle.ObserversCollector\":\"androidx.lifecycle.ObserversCollector\",\"android.arch.lifecycle.OnLifecycleEvent\":\"androidx.lifecycle.OnLifecycleEvent\",\"android.arch.lifecycle.ProcessLifecycleOwner\":\"androidx.lifecycle.ProcessLifecycleOwner\",\"android.arch.lifecycle.ProcessLifecycleOwnerInitializer\":\"androidx.lifecycle.ProcessLifecycleOwnerInitializer\",\"android.arch.lifecycle.ReflectiveGenericLifecycleObserver\":\"androidx.lifecycle.ReflectiveGenericLifecycleObserver\",\"android.arch.lifecycle.ReportFragment\":\"androidx.lifecycle.ReportFragment\",\"android.arch.lifecycle.ServiceLifecycleDispatcher\":\"androidx.lifecycle.ServiceLifecycleDispatcher\",\"android.arch.lifecycle.SingleGeneratedAdapterObserver\":\"androidx.lifecycle.SingleGeneratedAdapterObserver\",\"android.arch.lifecycle.TransformationKt\":\"androidx.lifecycle.TransformationKt\",\"android.arch.lifecycle.Transformations\":\"androidx.lifecycle.Transformations\",\"android.arch.lifecycle.Validator\":\"androidx.lifecycle.Validator\",\"android.arch.lifecycle.ViewModel\":\"androidx.lifecycle.ViewModel\",\"android.arch.lifecycle.ViewModelProvider\":\"androidx.lifecycle.ViewModelProvider\",\"android.arch.lifecycle.ViewModelProviders\":\"androidx.lifecycle.ViewModelProviders\",\"android.arch.lifecycle.ViewModelStore\":\"androidx.lifecycle.ViewModelStore\",\"android.arch.lifecycle.ViewModelStoreOwner\":\"androidx.lifecycle.ViewModelStoreOwner\",\"android.arch.lifecycle.ViewModelStores\":\"androidx.lifecycle.ViewModelStores\",\"android.arch.lifecycle.WriterKt\":\"androidx.lifecycle.WriterKt\",\"android.arch.paging.AsyncPagedListDiffer\":\"androidx.paging.AsyncPagedListDiffer\",\"android.arch.paging.ContiguousDataSource\":\"androidx.paging.ContiguousDataSource\",\"android.arch.paging.ContiguousPagedList\":\"androidx.paging.ContiguousPagedList\",\"android.arch.paging.DataSource\":\"androidx.paging.DataSource\",\"android.arch.paging.ItemKeyedDataSource\":\"androidx.paging.ItemKeyedDataSource\",\"android.arch.paging.ListDataSource\":\"androidx.paging.ListDataSource\",\"android.arch.paging.LivePagedListBuilder\":\"androidx.paging.LivePagedListBuilder\",\"android.arch.paging.LivePagedListProvider\":\"androidx.paging.LivePagedListProvider\",\"android.arch.paging.PagedList\":\"androidx.paging.PagedList\",\"android.arch.paging.PagedListAdapter\":\"androidx.paging.PagedListAdapter\",\"android.arch.paging.PagedStorage\":\"androidx.paging.PagedStorage\",\"android.arch.paging.PagedStorageDiffHelper\":\"androidx.paging.PagedStorageDiffHelper\",\"android.arch.paging.PageKeyedDataSource\":\"androidx.paging.PageKeyedDataSource\",\"android.arch.paging.PageResult\":\"androidx.paging.PageResult\",\"android.arch.paging.PositionalDataSource\":\"androidx.paging.PositionalDataSource\",\"android.arch.paging.RxPagedListBuilder\":\"androidx.paging.RxPagedListBuilder\",\"android.arch.paging.SnapshotPagedList\":\"androidx.paging.SnapshotPagedList\",\"android.arch.paging.TiledDataSource\":\"androidx.paging.TiledDataSource\",\"android.arch.paging.TiledPagedList\":\"androidx.paging.TiledPagedList\",\"android.arch.paging.WrapperItemKeyedDataSource\":\"androidx.paging.WrapperItemKeyedDataSource\",\"android.arch.paging.WrapperPageKeyedDataSource\":\"androidx.paging.WrapperPageKeyedDataSource\",\"android.arch.paging.WrapperPositionalDataSource\":\"androidx.paging.WrapperPositionalDataSource\",\"android.arch.persistence.db.framework.FrameworkSQLiteDatabase\":\"androidx.sqlite.db.framework.FrameworkSQLiteDatabase\",\"android.arch.persistence.db.framework.FrameworkSQLiteOpenHelper\":\"androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper\",\"android.arch.persistence.db.framework.FrameworkSQLiteOpenHelperFactory\":\"androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory\",\"android.arch.persistence.db.framework.FrameworkSQLiteProgram\":\"androidx.sqlite.db.framework.FrameworkSQLiteProgram\",\"android.arch.persistence.db.framework.FrameworkSQLiteStatement\":\"androidx.sqlite.db.framework.FrameworkSQLiteStatement\",\"android.arch.persistence.db.SimpleSQLiteQuery\":\"androidx.sqlite.db.SimpleSQLiteQuery\",\"android.arch.persistence.db.SupportSQLiteDatabase\":\"androidx.sqlite.db.SupportSQLiteDatabase\",\"android.arch.persistence.db.SupportSQLiteOpenHelper\":\"androidx.sqlite.db.SupportSQLiteOpenHelper\",\"android.arch.persistence.db.SupportSQLiteProgram\":\"androidx.sqlite.db.SupportSQLiteProgram\",\"android.arch.persistence.db.SupportSQLiteQuery\":\"androidx.sqlite.db.SupportSQLiteQuery\",\"android.arch.persistence.db.SupportSQLiteQueryBuilder\":\"androidx.sqlite.db.SupportSQLiteQueryBuilder\",\"android.arch.persistence.db.SupportSQLiteStatement\":\"androidx.sqlite.db.SupportSQLiteStatement\",\"android.arch.persistence.room.ColumnInfo\":\"androidx.room.ColumnInfo\",\"android.arch.persistence.room.Dao\":\"androidx.room.Dao\",\"android.arch.persistence.room.Database\":\"androidx.room.Database\",\"android.arch.persistence.room.DatabaseConfiguration\":\"androidx.room.DatabaseConfiguration\",\"android.arch.persistence.room.Delete\":\"androidx.room.Delete\",\"android.arch.persistence.room.Embedded\":\"androidx.room.Embedded\",\"android.arch.persistence.room.EmptyResultSetException\":\"androidx.room.EmptyResultSetException\",\"android.arch.persistence.room.Entity\":\"androidx.room.Entity\",\"android.arch.persistence.room.EntityDeletionOrUpdateAdapter\":\"androidx.room.EntityDeletionOrUpdateAdapter\",\"android.arch.persistence.room.EntityInsertionAdapter\":\"androidx.room.EntityInsertionAdapter\",\"android.arch.persistence.room.ext.AndroidTypeNames\":\"androidx.room.ext.AndroidTypeNames\",\"android.arch.persistence.room.ext.ArchTypeNames\":\"androidx.room.ext.ArchTypeNames\",\"android.arch.persistence.room.ext.CommonTypeNames\":\"androidx.room.ext.CommonTypeNames\",\"android.arch.persistence.room.ext.Element_extKt\":\"androidx.room.ext.Element_extKt\",\"android.arch.persistence.room.ext.GuavaBaseTypeNames\":\"androidx.room.ext.GuavaBaseTypeNames\",\"android.arch.persistence.room.ext.GuavaUtilConcurrentTypeNames\":\"androidx.room.ext.GuavaUtilConcurrentTypeNames\",\"android.arch.persistence.room.ext.Javapoet_extKt\":\"androidx.room.ext.Javapoet_extKt\",\"android.arch.persistence.room.ext.KotlinMetadataProcessor\":\"androidx.room.ext.KotlinMetadataProcessor\",\"android.arch.persistence.room.ext.LifecyclesTypeNames\":\"androidx.room.ext.LifecyclesTypeNames\",\"android.arch.persistence.room.ext.PagingTypeNames\":\"androidx.room.ext.PagingTypeNames\",\"android.arch.persistence.room.ext.ReactiveStreamsTypeNames\":\"androidx.room.ext.ReactiveStreamsTypeNames\",\"android.arch.persistence.room.ext.RoomGuavaTypeNames\":\"androidx.room.ext.RoomGuavaTypeNames\",\"android.arch.persistence.room.ext.RoomRxJava2TypeNames\":\"androidx.room.ext.RoomRxJava2TypeNames\",\"android.arch.persistence.room.ext.RoomTypeNames\":\"androidx.room.ext.RoomTypeNames\",\"android.arch.persistence.room.ext.RxJava2TypeNames\":\"androidx.room.ext.RxJava2TypeNames\",\"android.arch.persistence.room.ext.SupportDbTypeNames\":\"androidx.room.ext.SupportDbTypeNames\",\"android.arch.persistence.room.ForeignKey\":\"androidx.room.ForeignKey\",\"android.arch.persistence.room.guava.GuavaRoom\":\"androidx.room.guava.GuavaRoom\",\"android.arch.persistence.room.Ignore\":\"androidx.room.Ignore\",\"android.arch.persistence.room.Index\":\"androidx.room.Index\",\"android.arch.persistence.room.Insert\":\"androidx.room.Insert\",\"android.arch.persistence.room.InvalidationTracker\":\"androidx.room.InvalidationTracker\",\"android.arch.persistence.room.log.RLog\":\"androidx.room.log.RLog\",\"android.arch.persistence.room.migration.bundle.BundleUtil\":\"androidx.room.migration.bundle.BundleUtil\",\"android.arch.persistence.room.migration.bundle.DatabaseBundle\":\"androidx.room.migration.bundle.DatabaseBundle\",\"android.arch.persistence.room.migration.bundle.EntityBundle\":\"androidx.room.migration.bundle.EntityBundle\",\"android.arch.persistence.room.migration.bundle.FieldBundle\":\"androidx.room.migration.bundle.FieldBundle\",\"android.arch.persistence.room.migration.bundle.ForeignKeyBundle\":\"androidx.room.migration.bundle.ForeignKeyBundle\",\"android.arch.persistence.room.migration.bundle.IndexBundle\":\"androidx.room.migration.bundle.IndexBundle\",\"android.arch.persistence.room.migration.bundle.PrimaryKeyBundle\":\"androidx.room.migration.bundle.PrimaryKeyBundle\",\"android.arch.persistence.room.migration.bundle.SchemaBundle\":\"androidx.room.migration.bundle.SchemaBundle\",\"android.arch.persistence.room.migration.bundle.SchemaEquality\":\"androidx.room.migration.bundle.SchemaEquality\",\"android.arch.persistence.room.migration.bundle.SchemaEqualityUtil\":\"androidx.room.migration.bundle.SchemaEqualityUtil\",\"android.arch.persistence.room.migration.Migration\":\"androidx.room.migration.Migration\",\"android.arch.persistence.room.OnConflictStrategy\":\"androidx.room.OnConflictStrategy\",\"android.arch.persistence.room.paging.LimitOffsetDataSource\":\"androidx.room.paging.LimitOffsetDataSource\",\"android.arch.persistence.room.parser.Collate\":\"androidx.room.parser.Collate\",\"android.arch.persistence.room.parser.ParsedQuery\":\"androidx.room.parser.ParsedQuery\",\"android.arch.persistence.room.parser.ParserErrors\":\"androidx.room.parser.ParserErrors\",\"android.arch.persistence.room.parser.QueryType\":\"androidx.room.parser.QueryType\",\"android.arch.persistence.room.parser.QueryVisitor\":\"androidx.room.parser.QueryVisitor\",\"android.arch.persistence.room.parser.Section\":\"androidx.room.parser.Section\",\"android.arch.persistence.room.parser.SectionType\":\"androidx.room.parser.SectionType\",\"android.arch.persistence.room.parser.SQLiteBaseListener\":\"androidx.room.parser.SQLiteBaseListener\",\"android.arch.persistence.room.parser.SQLiteBaseVisitor\":\"androidx.room.parser.SQLiteBaseVisitor\",\"android.arch.persistence.room.parser.SQLiteLexer\":\"androidx.room.parser.SQLiteLexer\",\"android.arch.persistence.room.parser.SQLiteListener\":\"androidx.room.parser.SQLiteListener\",\"android.arch.persistence.room.parser.SQLiteParser\":\"androidx.room.parser.SQLiteParser\",\"android.arch.persistence.room.parser.SQLiteVisitor\":\"androidx.room.parser.SQLiteVisitor\",\"android.arch.persistence.room.parser.SqlParser\":\"androidx.room.parser.SqlParser\",\"android.arch.persistence.room.parser.SQLTypeAffinity\":\"androidx.room.parser.SQLTypeAffinity\",\"android.arch.persistence.room.parser.Table\":\"androidx.room.parser.Table\",\"android.arch.persistence.room.preconditions.Checks\":\"androidx.room.preconditions.Checks\",\"android.arch.persistence.room.PrimaryKey\":\"androidx.room.PrimaryKey\",\"android.arch.persistence.room.processor.cache.Cache\":\"androidx.room.processor.cache.Cache\",\"android.arch.persistence.room.processor.Context\":\"androidx.room.processor.Context\",\"android.arch.persistence.room.processor.CustomConverterProcessor\":\"androidx.room.processor.CustomConverterProcessor\",\"android.arch.persistence.room.processor.DaoProcessor\":\"androidx.room.processor.DaoProcessor\",\"android.arch.persistence.room.processor.DatabaseProcessor\":\"androidx.room.processor.DatabaseProcessor\",\"android.arch.persistence.room.processor.DeletionMethodProcessor\":\"androidx.room.processor.DeletionMethodProcessor\",\"android.arch.persistence.room.processor.EntityProcessor\":\"androidx.room.processor.EntityProcessor\",\"android.arch.persistence.room.processor.FieldProcessor\":\"androidx.room.processor.FieldProcessor\",\"android.arch.persistence.room.processor.InsertionMethodProcessor\":\"androidx.room.processor.InsertionMethodProcessor\",\"android.arch.persistence.room.processor.OnConflictProcessor\":\"androidx.room.processor.OnConflictProcessor\",\"android.arch.persistence.room.processor.PojoMethodProcessor\":\"androidx.room.processor.PojoMethodProcessor\",\"android.arch.persistence.room.processor.PojoProcessor\":\"androidx.room.processor.PojoProcessor\",\"android.arch.persistence.room.processor.ProcessorErrors\":\"androidx.room.processor.ProcessorErrors\",\"android.arch.persistence.room.processor.QueryMethodProcessor\":\"androidx.room.processor.QueryMethodProcessor\",\"android.arch.persistence.room.processor.QueryParameterProcessor\":\"androidx.room.processor.QueryParameterProcessor\",\"android.arch.persistence.room.processor.RawQueryMethodProcessor\":\"androidx.room.processor.RawQueryMethodProcessor\",\"android.arch.persistence.room.processor.ShortcutMethodProcessor\":\"androidx.room.processor.ShortcutMethodProcessor\",\"android.arch.persistence.room.processor.ShortcutParameterProcessor\":\"androidx.room.processor.ShortcutParameterProcessor\",\"android.arch.persistence.room.processor.SuppressWarningProcessor\":\"androidx.room.processor.SuppressWarningProcessor\",\"android.arch.persistence.room.processor.TransactionMethodProcessor\":\"androidx.room.processor.TransactionMethodProcessor\",\"android.arch.persistence.room.processor.UpdateMethodProcessor\":\"androidx.room.processor.UpdateMethodProcessor\",\"android.arch.persistence.room.Query\":\"androidx.room.Query\",\"android.arch.persistence.room.RawQuery\":\"androidx.room.RawQuery\",\"android.arch.persistence.room.Relation\":\"androidx.room.Relation\",\"android.arch.persistence.room.Room\":\"androidx.room.Room\",\"android.arch.persistence.room.RoomDatabase\":\"androidx.room.RoomDatabase\",\"android.arch.persistence.room.RoomMasterTable\":\"androidx.room.RoomMasterTable\",\"android.arch.persistence.room.RoomOpenHelper\":\"androidx.room.RoomOpenHelper\",\"android.arch.persistence.room.RoomProcessor\":\"androidx.room.RoomProcessor\",\"android.arch.persistence.room.RoomSQLiteQuery\":\"androidx.room.RoomSQLiteQuery\",\"android.arch.persistence.room.RoomWarnings\":\"androidx.room.RoomWarnings\",\"android.arch.persistence.room.RxRoom\":\"androidx.room.RxRoom\",\"android.arch.persistence.room.SharedSQLiteStatement\":\"androidx.room.SharedSQLiteStatement\",\"android.arch.persistence.room.SkipQueryVerification\":\"androidx.room.SkipQueryVerification\",\"android.arch.persistence.room.solver.binderprovider.CursorQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.CursorQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.DataSourceFactoryQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.DataSourceFactoryQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.DataSourceQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.DataSourceQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.FlowableQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.FlowableQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.GuavaListenableFutureQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.GuavaListenableFutureQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.InstantQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.InstantQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.LiveDataQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.LiveDataQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.RxCallableQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.RxCallableQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.RxMaybeQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.RxMaybeQueryResultBinderProvider\",\"android.arch.persistence.room.solver.binderprovider.RxSingleQueryResultBinderProvider\":\"androidx.room.solver.binderprovider.RxSingleQueryResultBinderProvider\",\"android.arch.persistence.room.solver.CodeGenScope\":\"androidx.room.solver.CodeGenScope\",\"android.arch.persistence.room.solver.ObservableQueryResultBinderProvider\":\"androidx.room.solver.ObservableQueryResultBinderProvider\",\"android.arch.persistence.room.solver.query.parameter.ArrayQueryParameterAdapter\":\"androidx.room.solver.query.parameter.ArrayQueryParameterAdapter\",\"android.arch.persistence.room.solver.query.parameter.BasicQueryParameterAdapter\":\"androidx.room.solver.query.parameter.BasicQueryParameterAdapter\",\"android.arch.persistence.room.solver.query.parameter.CollectionQueryParameterAdapter\":\"androidx.room.solver.query.parameter.CollectionQueryParameterAdapter\",\"android.arch.persistence.room.solver.query.parameter.QueryParameterAdapter\":\"androidx.room.solver.query.parameter.QueryParameterAdapter\",\"android.arch.persistence.room.solver.query.result.ArrayQueryResultAdapter\":\"androidx.room.solver.query.result.ArrayQueryResultAdapter\",\"android.arch.persistence.room.solver.query.result.BaseObservableQueryResultBinder\":\"androidx.room.solver.query.result.BaseObservableQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.CursorQueryResultBinder\":\"androidx.room.solver.query.result.CursorQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.DataSourceFactoryQueryResultBinder\":\"androidx.room.solver.query.result.DataSourceFactoryQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.EntityRowAdapter\":\"androidx.room.solver.query.result.EntityRowAdapter\",\"android.arch.persistence.room.solver.query.result.FlowableQueryResultBinder\":\"androidx.room.solver.query.result.FlowableQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.GuavaListenableFutureQueryResultBinder\":\"androidx.room.solver.query.result.GuavaListenableFutureQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.GuavaOptionalQueryResultAdapter\":\"androidx.room.solver.query.result.GuavaOptionalQueryResultAdapter\",\"android.arch.persistence.room.solver.query.result.InstantQueryResultBinder\":\"androidx.room.solver.query.result.InstantQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.ListQueryResultAdapter\":\"androidx.room.solver.query.result.ListQueryResultAdapter\",\"android.arch.persistence.room.solver.query.result.LiveDataQueryResultBinder\":\"androidx.room.solver.query.result.LiveDataQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.OptionalQueryResultAdapter\":\"androidx.room.solver.query.result.OptionalQueryResultAdapter\",\"android.arch.persistence.room.solver.query.result.PojoRowAdapter\":\"androidx.room.solver.query.result.PojoRowAdapter\",\"android.arch.persistence.room.solver.query.result.PositionalDataSourceQueryResultBinder\":\"androidx.room.solver.query.result.PositionalDataSourceQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.QueryResultAdapter\":\"androidx.room.solver.query.result.QueryResultAdapter\",\"android.arch.persistence.room.solver.query.result.QueryResultBinder\":\"androidx.room.solver.query.result.QueryResultBinder\",\"android.arch.persistence.room.solver.query.result.RowAdapter\":\"androidx.room.solver.query.result.RowAdapter\",\"android.arch.persistence.room.solver.query.result.RxCallableQueryResultBinder\":\"androidx.room.solver.query.result.RxCallableQueryResultBinder\",\"android.arch.persistence.room.solver.query.result.SingleColumnRowAdapter\":\"androidx.room.solver.query.result.SingleColumnRowAdapter\",\"android.arch.persistence.room.solver.query.result.SingleEntityQueryResultAdapter\":\"androidx.room.solver.query.result.SingleEntityQueryResultAdapter\",\"android.arch.persistence.room.solver.query.result.TransactionWrapper\":\"androidx.room.solver.query.result.TransactionWrapper\",\"android.arch.persistence.room.solver.query.result.TransactionWrapperKt\":\"androidx.room.solver.query.result.TransactionWrapperKt\",\"android.arch.persistence.room.solver.QueryResultBinderProvider\":\"androidx.room.solver.QueryResultBinderProvider\",\"android.arch.persistence.room.solver.TypeAdapterStore\":\"androidx.room.solver.TypeAdapterStore\",\"android.arch.persistence.room.solver.types.BoxedBooleanToBoxedIntConverter\":\"androidx.room.solver.types.BoxedBooleanToBoxedIntConverter\",\"android.arch.persistence.room.solver.types.BoxedPrimitiveColumnTypeAdapter\":\"androidx.room.solver.types.BoxedPrimitiveColumnTypeAdapter\",\"android.arch.persistence.room.solver.types.ByteArrayColumnTypeAdapter\":\"androidx.room.solver.types.ByteArrayColumnTypeAdapter\",\"android.arch.persistence.room.solver.types.ColumnTypeAdapter\":\"androidx.room.solver.types.ColumnTypeAdapter\",\"android.arch.persistence.room.solver.types.CompositeAdapter\":\"androidx.room.solver.types.CompositeAdapter\",\"android.arch.persistence.room.solver.types.CompositeTypeConverter\":\"androidx.room.solver.types.CompositeTypeConverter\",\"android.arch.persistence.room.solver.types.CursorValueReader\":\"androidx.room.solver.types.CursorValueReader\",\"android.arch.persistence.room.solver.types.CustomTypeConverterWrapper\":\"androidx.room.solver.types.CustomTypeConverterWrapper\",\"android.arch.persistence.room.solver.types.NoOpConverter\":\"androidx.room.solver.types.NoOpConverter\",\"android.arch.persistence.room.solver.types.PrimitiveBooleanToIntConverter\":\"androidx.room.solver.types.PrimitiveBooleanToIntConverter\",\"android.arch.persistence.room.solver.types.PrimitiveColumnTypeAdapter\":\"androidx.room.solver.types.PrimitiveColumnTypeAdapter\",\"android.arch.persistence.room.solver.types.StatementValueBinder\":\"androidx.room.solver.types.StatementValueBinder\",\"android.arch.persistence.room.solver.types.StringColumnTypeAdapter\":\"androidx.room.solver.types.StringColumnTypeAdapter\",\"android.arch.persistence.room.solver.types.TypeConverter\":\"androidx.room.solver.types.TypeConverter\",\"android.arch.persistence.room.testing.MigrationTestHelper\":\"androidx.room.testing.MigrationTestHelper\",\"android.arch.persistence.room.Transaction\":\"androidx.room.Transaction\",\"android.arch.persistence.room.TypeConverter\":\"androidx.room.TypeConverter\",\"android.arch.persistence.room.TypeConverters\":\"androidx.room.TypeConverters\",\"android.arch.persistence.room.Update\":\"androidx.room.Update\",\"android.arch.persistence.room.util.StringUtil\":\"androidx.room.util.StringUtil\",\"android.arch.persistence.room.util.TableInfo\":\"androidx.room.util.TableInfo\",\"android.arch.persistence.room.verifier.ColumnInfo\":\"androidx.room.verifier.ColumnInfo\",\"android.arch.persistence.room.verifier.DatabaseVerificationErrors\":\"androidx.room.verifier.DatabaseVerificationErrors\",\"android.arch.persistence.room.verifier.DatabaseVerifier\":\"androidx.room.verifier.DatabaseVerifier\",\"android.arch.persistence.room.verifier.QueryResultInfo\":\"androidx.room.verifier.QueryResultInfo\",\"android.arch.persistence.room.vo.CallType\":\"androidx.room.vo.CallType\",\"android.arch.persistence.room.vo.Constructor\":\"androidx.room.vo.Constructor\",\"android.arch.persistence.room.vo.CustomTypeConverter\":\"androidx.room.vo.CustomTypeConverter\",\"android.arch.persistence.room.vo.Dao\":\"androidx.room.vo.Dao\",\"android.arch.persistence.room.vo.DaoMethod\":\"androidx.room.vo.DaoMethod\",\"android.arch.persistence.room.vo.Database\":\"androidx.room.vo.Database\",\"android.arch.persistence.room.vo.DeletionMethod\":\"androidx.room.vo.DeletionMethod\",\"android.arch.persistence.room.vo.EmbeddedField\":\"androidx.room.vo.EmbeddedField\",\"android.arch.persistence.room.vo.Entity\":\"androidx.room.vo.Entity\",\"android.arch.persistence.room.vo.Field\":\"androidx.room.vo.Field\",\"android.arch.persistence.room.vo.FieldGetter\":\"androidx.room.vo.FieldGetter\",\"android.arch.persistence.room.vo.FieldSetter\":\"androidx.room.vo.FieldSetter\",\"android.arch.persistence.room.vo.FieldWithIndex\":\"androidx.room.vo.FieldWithIndex\",\"android.arch.persistence.room.vo.ForeignKey\":\"androidx.room.vo.ForeignKey\",\"android.arch.persistence.room.vo.ForeignKeyAction\":\"androidx.room.vo.ForeignKeyAction\",\"android.arch.persistence.room.vo.HasSchemaIdentity\":\"androidx.room.vo.HasSchemaIdentity\",\"android.arch.persistence.room.vo.Index\":\"androidx.room.vo.Index\",\"android.arch.persistence.room.vo.InsertionMethod\":\"androidx.room.vo.InsertionMethod\",\"android.arch.persistence.room.vo.Pojo\":\"androidx.room.vo.Pojo\",\"android.arch.persistence.room.vo.PojoMethod\":\"androidx.room.vo.PojoMethod\",\"android.arch.persistence.room.vo.PrimaryKey\":\"androidx.room.vo.PrimaryKey\",\"android.arch.persistence.room.vo.QueryMethod\":\"androidx.room.vo.QueryMethod\",\"android.arch.persistence.room.vo.QueryParameter\":\"androidx.room.vo.QueryParameter\",\"android.arch.persistence.room.vo.RawQueryMethod\":\"androidx.room.vo.RawQueryMethod\",\"android.arch.persistence.room.vo.Relation\":\"androidx.room.vo.Relation\",\"android.arch.persistence.room.vo.RelationCollector\":\"androidx.room.vo.RelationCollector\",\"android.arch.persistence.room.vo.SchemaIdentityKey\":\"androidx.room.vo.SchemaIdentityKey\",\"android.arch.persistence.room.vo.ShortcutMethod\":\"androidx.room.vo.ShortcutMethod\",\"android.arch.persistence.room.vo.ShortcutQueryParameter\":\"androidx.room.vo.ShortcutQueryParameter\",\"android.arch.persistence.room.vo.TransactionMethod\":\"androidx.room.vo.TransactionMethod\",\"android.arch.persistence.room.vo.UpdateMethod\":\"androidx.room.vo.UpdateMethod\",\"android.arch.persistence.room.vo.Warning\":\"androidx.room.vo.Warning\",\"android.arch.persistence.room.writer.ClassWriter\":\"androidx.room.writer.ClassWriter\",\"android.arch.persistence.room.writer.DaoWriter\":\"androidx.room.writer.DaoWriter\",\"android.arch.persistence.room.writer.DatabaseWriter\":\"androidx.room.writer.DatabaseWriter\",\"android.arch.persistence.room.writer.EntityCursorConverterWriter\":\"androidx.room.writer.EntityCursorConverterWriter\",\"android.arch.persistence.room.writer.EntityDeleteComparator\":\"androidx.room.writer.EntityDeleteComparator\",\"android.arch.persistence.room.writer.EntityDeletionAdapterWriter\":\"androidx.room.writer.EntityDeletionAdapterWriter\",\"android.arch.persistence.room.writer.EntityInsertionAdapterWriter\":\"androidx.room.writer.EntityInsertionAdapterWriter\",\"android.arch.persistence.room.writer.EntityUpdateAdapterWriter\":\"androidx.room.writer.EntityUpdateAdapterWriter\",\"android.arch.persistence.room.writer.FieldReadWriteWriter\":\"androidx.room.writer.FieldReadWriteWriter\",\"android.arch.persistence.room.writer.PreparedStatementWriter\":\"androidx.room.writer.PreparedStatementWriter\",\"android.arch.persistence.room.writer.QueryWriter\":\"androidx.room.writer.QueryWriter\",\"android.arch.persistence.room.writer.RelationCollectorMethodWriter\":\"androidx.room.writer.RelationCollectorMethodWriter\",\"android.arch.persistence.room.writer.SQLiteOpenHelperWriter\":\"androidx.room.writer.SQLiteOpenHelperWriter\",\"android.arch.persistence.room.writer.TableInfoValidationWriter\":\"androidx.room.writer.TableInfoValidationWriter\",\"android.databinding.adapters.AbsListViewBindingAdapter\":\"androidx.databinding.adapters.AbsListViewBindingAdapter\",\"android.databinding.adapters.AbsSeekBarBindingAdapter\":\"androidx.databinding.adapters.AbsSeekBarBindingAdapter\",\"android.databinding.adapters.AbsSpinnerBindingAdapter\":\"androidx.databinding.adapters.AbsSpinnerBindingAdapter\",\"android.databinding.adapters.ActionMenuViewBindingAdapter\":\"androidx.databinding.adapters.ActionMenuViewBindingAdapter\",\"android.databinding.adapters.AdapterViewBindingAdapter\":\"androidx.databinding.adapters.AdapterViewBindingAdapter\",\"android.databinding.adapters.AutoCompleteTextViewBindingAdapter\":\"androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter\",\"android.databinding.adapters.CalendarViewBindingAdapter\":\"androidx.databinding.adapters.CalendarViewBindingAdapter\",\"android.databinding.adapters.CardViewBindingAdapter\":\"androidx.databinding.adapters.CardViewBindingAdapter\",\"android.databinding.adapters.CheckedTextViewBindingAdapter\":\"androidx.databinding.adapters.CheckedTextViewBindingAdapter\",\"android.databinding.adapters.ChronometerBindingAdapter\":\"androidx.databinding.adapters.ChronometerBindingAdapter\",\"android.databinding.adapters.CompoundButtonBindingAdapter\":\"androidx.databinding.adapters.CompoundButtonBindingAdapter\",\"android.databinding.adapters.Converters\":\"androidx.databinding.adapters.Converters\",\"android.databinding.adapters.DatePickerBindingAdapter\":\"androidx.databinding.adapters.DatePickerBindingAdapter\",\"android.databinding.adapters.ExpandableListViewBindingAdapter\":\"androidx.databinding.adapters.ExpandableListViewBindingAdapter\",\"android.databinding.adapters.FrameLayoutBindingAdapter\":\"androidx.databinding.adapters.FrameLayoutBindingAdapter\",\"android.databinding.adapters.ImageViewBindingAdapter\":\"androidx.databinding.adapters.ImageViewBindingAdapter\",\"android.databinding.adapters.LinearLayoutBindingAdapter\":\"androidx.databinding.adapters.LinearLayoutBindingAdapter\",\"android.databinding.adapters.ListenerUtil\":\"androidx.databinding.adapters.ListenerUtil\",\"android.databinding.adapters.NumberPickerBindingAdapter\":\"androidx.databinding.adapters.NumberPickerBindingAdapter\",\"android.databinding.adapters.ObservableListAdapter\":\"androidx.databinding.adapters.ObservableListAdapter\",\"android.databinding.adapters.ProgressBarBindingAdapter\":\"androidx.databinding.adapters.ProgressBarBindingAdapter\",\"android.databinding.adapters.RadioGroupBindingAdapter\":\"androidx.databinding.adapters.RadioGroupBindingAdapter\",\"android.databinding.adapters.RatingBarBindingAdapter\":\"androidx.databinding.adapters.RatingBarBindingAdapter\",\"android.databinding.adapters.SearchViewBindingAdapter\":\"androidx.databinding.adapters.SearchViewBindingAdapter\",\"android.databinding.adapters.SeekBarBindingAdapter\":\"androidx.databinding.adapters.SeekBarBindingAdapter\",\"android.databinding.adapters.SpinnerBindingAdapter\":\"androidx.databinding.adapters.SpinnerBindingAdapter\",\"android.databinding.adapters.SwitchBindingAdapter\":\"androidx.databinding.adapters.SwitchBindingAdapter\",\"android.databinding.adapters.SwitchCompatBindingAdapter\":\"androidx.databinding.adapters.SwitchCompatBindingAdapter\",\"android.databinding.adapters.TabHostBindingAdapter\":\"androidx.databinding.adapters.TabHostBindingAdapter\",\"android.databinding.adapters.TableLayoutBindingAdapter\":\"androidx.databinding.adapters.TableLayoutBindingAdapter\",\"android.databinding.adapters.TabWidgetBindingAdapter\":\"androidx.databinding.adapters.TabWidgetBindingAdapter\",\"android.databinding.adapters.TextViewBindingAdapter\":\"androidx.databinding.adapters.TextViewBindingAdapter\",\"android.databinding.adapters.TimePickerBindingAdapter\":\"androidx.databinding.adapters.TimePickerBindingAdapter\",\"android.databinding.adapters.ToolbarBindingAdapter\":\"androidx.databinding.adapters.ToolbarBindingAdapter\",\"android.databinding.adapters.VideoViewBindingAdapter\":\"androidx.databinding.adapters.VideoViewBindingAdapter\",\"android.databinding.adapters.ViewBindingAdapter\":\"androidx.databinding.adapters.ViewBindingAdapter\",\"android.databinding.adapters.ViewGroupBindingAdapter\":\"androidx.databinding.adapters.ViewGroupBindingAdapter\",\"android.databinding.adapters.ViewStubBindingAdapter\":\"androidx.databinding.adapters.ViewStubBindingAdapter\",\"android.databinding.adapters.ZoomControlsBindingAdapter\":\"androidx.databinding.adapters.ZoomControlsBindingAdapter\",\"android.databinding.BaseObservable\":\"androidx.databinding.BaseObservable\",\"android.databinding.BaseObservableField\":\"androidx.databinding.BaseObservableField\",\"android.databinding.Bindable\":\"androidx.databinding.Bindable\",\"android.databinding.BindingAdapter\":\"androidx.databinding.BindingAdapter\",\"android.databinding.BindingBuildInfo\":\"androidx.databinding.BindingBuildInfo\",\"android.databinding.BindingConversion\":\"androidx.databinding.BindingConversion\",\"android.databinding.BindingMethod\":\"androidx.databinding.BindingMethod\",\"android.databinding.BindingMethods\":\"androidx.databinding.BindingMethods\",\"android.databinding.CallbackRegistry\":\"androidx.databinding.CallbackRegistry\",\"android.databinding.DataBinderMapper\":\"androidx.databinding.DataBinderMapper\",\"android.databinding.DataBinderMapperImpl\":\"androidx.databinding.DataBinderMapperImpl\",\"android.databinding.DataBindingComponent\":\"androidx.databinding.DataBindingComponent\",\"android.databinding.DataBindingUtil\":\"androidx.databinding.DataBindingUtil\",\"android.databinding.InverseBindingAdapter\":\"androidx.databinding.InverseBindingAdapter\",\"android.databinding.InverseBindingListener\":\"androidx.databinding.InverseBindingListener\",\"android.databinding.InverseBindingMethod\":\"androidx.databinding.InverseBindingMethod\",\"android.databinding.InverseBindingMethods\":\"androidx.databinding.InverseBindingMethods\",\"android.databinding.InverseMethod\":\"androidx.databinding.InverseMethod\",\"android.databinding.ListChangeRegistry\":\"androidx.databinding.ListChangeRegistry\",\"android.databinding.MapChangeRegistry\":\"androidx.databinding.MapChangeRegistry\",\"android.databinding.MergedDataBinderMapper\":\"androidx.databinding.MergedDataBinderMapper\",\"android.databinding.Observable\":\"androidx.databinding.Observable\",\"android.databinding.ObservableArrayList\":\"androidx.databinding.ObservableArrayList\",\"android.databinding.ObservableArrayMap\":\"androidx.databinding.ObservableArrayMap\",\"android.databinding.ObservableBoolean\":\"androidx.databinding.ObservableBoolean\",\"android.databinding.ObservableByte\":\"androidx.databinding.ObservableByte\",\"android.databinding.ObservableChar\":\"androidx.databinding.ObservableChar\",\"android.databinding.ObservableDouble\":\"androidx.databinding.ObservableDouble\",\"android.databinding.ObservableField\":\"androidx.databinding.ObservableField\",\"android.databinding.ObservableFloat\":\"androidx.databinding.ObservableFloat\",\"android.databinding.ObservableInt\":\"androidx.databinding.ObservableInt\",\"android.databinding.ObservableList\":\"androidx.databinding.ObservableList\",\"android.databinding.ObservableLong\":\"androidx.databinding.ObservableLong\",\"android.databinding.ObservableMap\":\"androidx.databinding.ObservableMap\",\"android.databinding.ObservableParcelable\":\"androidx.databinding.ObservableParcelable\",\"android.databinding.ObservableShort\":\"androidx.databinding.ObservableShort\",\"android.databinding.OnRebindCallback\":\"androidx.databinding.OnRebindCallback\",\"android.databinding.PropertyChangeRegistry\":\"androidx.databinding.PropertyChangeRegistry\",\"android.databinding.Untaggable\":\"androidx.databinding.Untaggable\",\"android.databinding.ViewDataBinding\":\"androidx.databinding.ViewDataBinding\",\"android.databinding.ViewStubProxy\":\"androidx.databinding.ViewStubProxy\",\"android.support.animation.AnimationHandler\":\"androidx.dynamicanimation.animation.AnimationHandler\",\"android.support.animation.DynamicAnimation\":\"androidx.dynamicanimation.animation.DynamicAnimation\",\"android.support.animation.FlingAnimation\":\"androidx.dynamicanimation.animation.FlingAnimation\",\"android.support.animation.FloatPropertyCompat\":\"androidx.dynamicanimation.animation.FloatPropertyCompat\",\"android.support.animation.FloatValueHolder\":\"androidx.dynamicanimation.animation.FloatValueHolder\",\"android.support.animation.Force\":\"androidx.dynamicanimation.animation.Force\",\"android.support.animation.SpringAnimation\":\"androidx.dynamicanimation.animation.SpringAnimation\",\"android.support.animation.SpringForce\":\"androidx.dynamicanimation.animation.SpringForce\",\"android.support.annotation.AnimatorRes\":\"androidx.annotation.AnimatorRes\",\"android.support.annotation.AnimRes\":\"androidx.annotation.AnimRes\",\"android.support.annotation.AnyRes\":\"androidx.annotation.AnyRes\",\"android.support.annotation.AnyThread\":\"androidx.annotation.AnyThread\",\"android.support.annotation.ArrayRes\":\"androidx.annotation.ArrayRes\",\"android.support.annotation.AttrRes\":\"androidx.annotation.AttrRes\",\"android.support.annotation.BinderThread\":\"androidx.annotation.BinderThread\",\"android.support.annotation.BoolRes\":\"androidx.annotation.BoolRes\",\"android.support.annotation.CallSuper\":\"androidx.annotation.CallSuper\",\"android.support.annotation.CheckResult\":\"androidx.annotation.CheckResult\",\"android.support.annotation.ColorInt\":\"androidx.annotation.ColorInt\",\"android.support.annotation.ColorLong\":\"androidx.annotation.ColorLong\",\"android.support.annotation.ColorRes\":\"androidx.annotation.ColorRes\",\"android.support.annotation.DimenRes\":\"androidx.annotation.DimenRes\",\"android.support.annotation.Dimension\":\"androidx.annotation.Dimension\",\"android.support.annotation.DrawableRes\":\"androidx.annotation.DrawableRes\",\"android.support.annotation.FloatRange\":\"androidx.annotation.FloatRange\",\"android.support.annotation.FontRes\":\"androidx.annotation.FontRes\",\"android.support.annotation.FractionRes\":\"androidx.annotation.FractionRes\",\"android.support.annotation.GuardedBy\":\"androidx.annotation.GuardedBy\",\"android.support.annotation.HalfFloat\":\"androidx.annotation.HalfFloat\",\"android.support.annotation.IdRes\":\"androidx.annotation.IdRes\",\"android.support.annotation.IntDef\":\"androidx.annotation.IntDef\",\"android.support.annotation.IntegerRes\":\"androidx.annotation.IntegerRes\",\"android.support.annotation.InterpolatorRes\":\"androidx.annotation.InterpolatorRes\",\"android.support.annotation.IntRange\":\"androidx.annotation.IntRange\",\"android.support.annotation.Keep\":\"androidx.annotation.Keep\",\"android.support.annotation.LayoutRes\":\"androidx.annotation.LayoutRes\",\"android.support.annotation.LongDef\":\"androidx.annotation.LongDef\",\"android.support.annotation.MainThread\":\"androidx.annotation.MainThread\",\"android.support.annotation.MenuRes\":\"androidx.annotation.MenuRes\",\"android.support.annotation.NavigationRes\":\"androidx.annotation.NavigationRes\",\"android.support.annotation.NonNull\":\"androidx.annotation.NonNull\",\"android.support.annotation.Nullable\":\"androidx.annotation.Nullable\",\"android.support.annotation.PluralsRes\":\"androidx.annotation.PluralsRes\",\"android.support.annotation.Px\":\"androidx.annotation.Px\",\"android.support.annotation.RawRes\":\"androidx.annotation.RawRes\",\"android.support.annotation.RequiresApi\":\"androidx.annotation.RequiresApi\",\"android.support.annotation.RequiresFeature\":\"androidx.annotation.RequiresFeature\",\"android.support.annotation.RequiresPermission\":\"androidx.annotation.RequiresPermission\",\"android.support.annotation.RestrictTo\":\"androidx.annotation.RestrictTo\",\"android.support.annotation.Size\":\"androidx.annotation.Size\",\"android.support.annotation.StringDef\":\"androidx.annotation.StringDef\",\"android.support.annotation.StringRes\":\"androidx.annotation.StringRes\",\"android.support.annotation.StyleableRes\":\"androidx.annotation.StyleableRes\",\"android.support.annotation.StyleRes\":\"androidx.annotation.StyleRes\",\"android.support.annotation.TransitionRes\":\"androidx.annotation.TransitionRes\",\"android.support.annotation.UiThread\":\"androidx.annotation.UiThread\",\"android.support.annotation.VisibleForTesting\":\"androidx.annotation.VisibleForTesting\",\"android.support.annotation.WorkerThread\":\"androidx.annotation.WorkerThread\",\"android.support.annotation.XmlRes\":\"androidx.annotation.XmlRes\",\"android.support.app.recommendation.ContentRecommendation\":\"androidx.recommendation.app.ContentRecommendation\",\"android.support.app.recommendation.RecommendationExtender\":\"androidx.recommendation.app.RecommendationExtender\",\"android.support.compat.R\":\"androidx.core.R\",\"android.support.constraint.Barrier\":\"androidx.constraintlayout.widget.Barrier\",\"android.support.constraint.ConstraintHelper\":\"androidx.constraintlayout.widget.ConstraintHelper\",\"android.support.constraint.ConstraintLayout\":\"androidx.constraintlayout.widget.ConstraintLayout\",\"android.support.constraint.Constraints\":\"androidx.constraintlayout.widget.Constraints\",\"android.support.constraint.ConstraintSet\":\"androidx.constraintlayout.widget.ConstraintSet\",\"android.support.constraint.Group\":\"androidx.constraintlayout.widget.Group\",\"android.support.constraint.Guideline\":\"androidx.constraintlayout.widget.Guideline\",\"android.support.constraint.Placeholder\":\"androidx.constraintlayout.widget.Placeholder\",\"android.support.constraint.R\":\"androidx.constraintlayout.widget.R\",\"android.support.constraint.solver.ArrayLinkedVariables\":\"androidx.constraintlayout.solver.ArrayLinkedVariables\",\"android.support.constraint.solver.ArrayRow\":\"androidx.constraintlayout.solver.ArrayRow\",\"android.support.constraint.solver.Cache\":\"androidx.constraintlayout.solver.Cache\",\"android.support.constraint.solver.GoalRow\":\"androidx.constraintlayout.solver.GoalRow\",\"android.support.constraint.solver.LinearSystem\":\"androidx.constraintlayout.solver.LinearSystem\",\"android.support.constraint.solver.Metrics\":\"androidx.constraintlayout.solver.Metrics\",\"android.support.constraint.solver.Pools\":\"androidx.constraintlayout.solver.Pools\",\"android.support.constraint.solver.SolverVariable\":\"androidx.constraintlayout.solver.SolverVariable\",\"android.support.constraint.solver.widgets.Analyzer\":\"androidx.constraintlayout.solver.widgets.Analyzer\",\"android.support.constraint.solver.widgets.Barrier\":\"androidx.constraintlayout.solver.widgets.Barrier\",\"android.support.constraint.solver.widgets.Chain\":\"androidx.constraintlayout.solver.widgets.Chain\",\"android.support.constraint.solver.widgets.ChainHead\":\"androidx.constraintlayout.solver.widgets.ChainHead\",\"android.support.constraint.solver.widgets.ConstraintAnchor\":\"androidx.constraintlayout.solver.widgets.ConstraintAnchor\",\"android.support.constraint.solver.widgets.ConstraintHorizontalLayout\":\"androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout\",\"android.support.constraint.solver.widgets.ConstraintTableLayout\":\"androidx.constraintlayout.solver.widgets.ConstraintTableLayout\",\"android.support.constraint.solver.widgets.ConstraintWidget\":\"androidx.constraintlayout.solver.widgets.ConstraintWidget\",\"android.support.constraint.solver.widgets.ConstraintWidgetContainer\":\"androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer\",\"android.support.constraint.solver.widgets.ConstraintWidgetGroup\":\"androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup\",\"android.support.constraint.solver.widgets.Guideline\":\"androidx.constraintlayout.solver.widgets.Guideline\",\"android.support.constraint.solver.widgets.Helper\":\"androidx.constraintlayout.solver.widgets.Helper\",\"android.support.constraint.solver.widgets.Optimizer\":\"androidx.constraintlayout.solver.widgets.Optimizer\",\"android.support.constraint.solver.widgets.Rectangle\":\"androidx.constraintlayout.solver.widgets.Rectangle\",\"android.support.constraint.solver.widgets.ResolutionAnchor\":\"androidx.constraintlayout.solver.widgets.ResolutionAnchor\",\"android.support.constraint.solver.widgets.ResolutionDimension\":\"androidx.constraintlayout.solver.widgets.ResolutionDimension\",\"android.support.constraint.solver.widgets.ResolutionNode\":\"androidx.constraintlayout.solver.widgets.ResolutionNode\",\"android.support.constraint.solver.widgets.Snapshot\":\"androidx.constraintlayout.solver.widgets.Snapshot\",\"android.support.constraint.solver.widgets.WidgetContainer\":\"androidx.constraintlayout.solver.widgets.WidgetContainer\",\"android.support.content.ContentPager\":\"androidx.contentpager.content.ContentPager\",\"android.support.content.InMemoryCursor\":\"androidx.contentpager.content.InMemoryCursor\",\"android.support.content.LoaderQueryRunner\":\"androidx.contentpager.content.LoaderQueryRunner\",\"android.support.content.Query\":\"androidx.contentpager.content.Query\",\"android.support.coordinatorlayout.R\":\"androidx.coordinatorlayout.R\",\"android.support.customtabs.CustomTabsCallback\":\"androidx.browser.customtabs.CustomTabsCallback\",\"android.support.customtabs.CustomTabsClient\":\"androidx.browser.customtabs.CustomTabsClient\",\"android.support.customtabs.CustomTabsIntent\":\"androidx.browser.customtabs.CustomTabsIntent\",\"android.support.customtabs.CustomTabsService\":\"androidx.browser.customtabs.CustomTabsService\",\"android.support.customtabs.CustomTabsServiceConnection\":\"androidx.browser.customtabs.CustomTabsServiceConnection\",\"android.support.customtabs.CustomTabsSession\":\"androidx.browser.customtabs.CustomTabsSession\",\"android.support.customtabs.CustomTabsSessionToken\":\"androidx.browser.customtabs.CustomTabsSessionToken\",\"android.support.customtabs.ICustomTabsCallback\":\"android.support.customtabs.ICustomTabsCallback\",\"android.support.customtabs.ICustomTabsService\":\"android.support.customtabs.ICustomTabsService\",\"android.support.customtabs.IPostMessageService\":\"android.support.customtabs.IPostMessageService\",\"android.support.customtabs.PostMessageService\":\"androidx.browser.customtabs.PostMessageService\",\"android.support.customtabs.PostMessageServiceConnection\":\"androidx.browser.customtabs.PostMessageServiceConnection\",\"android.support.customtabs.R\":\"androidx.browser.R\",\"android.support.customtabs.TrustedWebUtils\":\"androidx.browser.customtabs.TrustedWebUtils\",\"android.support.design.animation.AnimationUtils\":\"com.google.android.material.animation.AnimationUtils\",\"android.support.design.animation.AnimatorSetCompat\":\"com.google.android.material.animation.AnimatorSetCompat\",\"android.support.design.animation.ArgbEvaluatorCompat\":\"com.google.android.material.animation.ArgbEvaluatorCompat\",\"android.support.design.animation.ChildrenAlphaProperty\":\"com.google.android.material.animation.ChildrenAlphaProperty\",\"android.support.design.animation.DrawableAlphaProperty\":\"com.google.android.material.animation.DrawableAlphaProperty\",\"android.support.design.animation.ImageMatrixProperty\":\"com.google.android.material.animation.ImageMatrixProperty\",\"android.support.design.animation.MatrixEvaluator\":\"com.google.android.material.animation.MatrixEvaluator\",\"android.support.design.animation.MotionSpec\":\"com.google.android.material.animation.MotionSpec\",\"android.support.design.animation.MotionTiming\":\"com.google.android.material.animation.MotionTiming\",\"android.support.design.animation.Positioning\":\"com.google.android.material.animation.Positioning\",\"android.support.design.behavior.HideBottomViewOnScrollBehavior\":\"com.google.android.material.behavior.HideBottomViewOnScrollBehavior\",\"android.support.design.bottomappbar.BottomAppBar\":\"com.google.android.material.bottomappbar.BottomAppBar\",\"android.support.design.bottomappbar.BottomAppBarTopEdgeTreatment\":\"com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment\",\"android.support.design.bottomnavigation.LabelVisibilityMode\":\"com.google.android.material.bottomnavigation.LabelVisibilityMode\",\"android.support.design.button.MaterialButton\":\"com.google.android.material.button.MaterialButton\",\"android.support.design.button.MaterialButtonBackgroundDrawable\":\"com.google.android.material.button.MaterialButtonBackgroundDrawable\",\"android.support.design.button.MaterialButtonHelper\":\"com.google.android.material.button.MaterialButtonHelper\",\"android.support.design.canvas.CanvasCompat\":\"com.google.android.material.canvas.CanvasCompat\",\"android.support.design.card.MaterialCardView\":\"com.google.android.material.card.MaterialCardView\",\"android.support.design.card.MaterialCardViewHelper\":\"com.google.android.material.card.MaterialCardViewHelper\",\"android.support.design.chip.Chip\":\"com.google.android.material.chip.Chip\",\"android.support.design.chip.ChipDrawable\":\"com.google.android.material.chip.ChipDrawable\",\"android.support.design.chip.ChipGroup\":\"com.google.android.material.chip.ChipGroup\",\"android.support.design.circularreveal.cardview.CircularRevealCardView\":\"com.google.android.material.circularreveal.cardview.CircularRevealCardView\",\"android.support.design.circularreveal.CircularRevealCompat\":\"com.google.android.material.circularreveal.CircularRevealCompat\",\"android.support.design.circularreveal.CircularRevealFrameLayout\":\"com.google.android.material.circularreveal.CircularRevealFrameLayout\",\"android.support.design.circularreveal.CircularRevealGridLayout\":\"com.google.android.material.circularreveal.CircularRevealGridLayout\",\"android.support.design.circularreveal.CircularRevealHelper\":\"com.google.android.material.circularreveal.CircularRevealHelper\",\"android.support.design.circularreveal.CircularRevealLinearLayout\":\"com.google.android.material.circularreveal.CircularRevealLinearLayout\",\"android.support.design.circularreveal.CircularRevealRelativeLayout\":\"com.google.android.material.circularreveal.CircularRevealRelativeLayout\",\"android.support.design.circularreveal.CircularRevealWidget\":\"com.google.android.material.circularreveal.CircularRevealWidget\",\"android.support.design.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout\":\"com.google.android.material.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout\",\"android.support.design.drawable.DrawableUtils\":\"com.google.android.material.drawable.DrawableUtils\",\"android.support.design.expandable.ExpandableTransformationWidget\":\"com.google.android.material.expandable.ExpandableTransformationWidget\",\"android.support.design.expandable.ExpandableWidget\":\"com.google.android.material.expandable.ExpandableWidget\",\"android.support.design.expandable.ExpandableWidgetHelper\":\"com.google.android.material.expandable.ExpandableWidgetHelper\",\"android.support.design.internal.BaselineLayout\":\"com.google.android.material.internal.BaselineLayout\",\"android.support.design.internal.BottomNavigationItemView\":\"com.google.android.material.bottomnavigation.BottomNavigationItemView\",\"android.support.design.internal.BottomNavigationMenu\":\"com.google.android.material.bottomnavigation.BottomNavigationMenu\",\"android.support.design.internal.BottomNavigationMenuView\":\"com.google.android.material.bottomnavigation.BottomNavigationMenuView\",\"android.support.design.internal.BottomNavigationPresenter\":\"com.google.android.material.bottomnavigation.BottomNavigationPresenter\",\"android.support.design.internal.Experimental\":\"com.google.android.material.internal.Experimental\",\"android.support.design.internal.FlowLayout\":\"com.google.android.material.internal.FlowLayout\",\"android.support.design.internal.ForegroundLinearLayout\":\"com.google.android.material.internal.ForegroundLinearLayout\",\"android.support.design.internal.NavigationMenu\":\"com.google.android.material.internal.NavigationMenu\",\"android.support.design.internal.NavigationMenuItemView\":\"com.google.android.material.internal.NavigationMenuItemView\",\"android.support.design.internal.NavigationMenuPresenter\":\"com.google.android.material.internal.NavigationMenuPresenter\",\"android.support.design.internal.NavigationMenuView\":\"com.google.android.material.internal.NavigationMenuView\",\"android.support.design.internal.NavigationSubMenu\":\"com.google.android.material.internal.NavigationSubMenu\",\"android.support.design.internal.ParcelableSparseArray\":\"com.google.android.material.internal.ParcelableSparseArray\",\"android.support.design.internal.ScrimInsetsFrameLayout\":\"com.google.android.material.internal.ScrimInsetsFrameLayout\",\"android.support.design.internal.TextScale\":\"com.google.android.material.internal.TextScale\",\"android.support.design.internal.ThemeEnforcement\":\"com.google.android.material.internal.ThemeEnforcement\",\"android.support.design.internal.ViewUtils\":\"com.google.android.material.internal.ViewUtils\",\"android.support.design.R\":\"com.google.android.material.R\",\"android.support.design.resources.MaterialResources\":\"com.google.android.material.resources.MaterialResources\",\"android.support.design.resources.TextAppearance\":\"com.google.android.material.resources.TextAppearance\",\"android.support.design.resources.TextAppearanceConfig\":\"com.google.android.material.resources.TextAppearanceConfig\",\"android.support.design.ripple.RippleUtils\":\"com.google.android.material.ripple.RippleUtils\",\"android.support.design.shape.CornerTreatment\":\"com.google.android.material.shape.CornerTreatment\",\"android.support.design.shape.CutCornerTreatment\":\"com.google.android.material.shape.CutCornerTreatment\",\"android.support.design.shape.EdgeTreatment\":\"com.google.android.material.shape.EdgeTreatment\",\"android.support.design.shape.InterpolateOnScrollPositionChangeHelper\":\"com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper\",\"android.support.design.shape.MaterialShapeDrawable\":\"com.google.android.material.shape.MaterialShapeDrawable\",\"android.support.design.shape.RoundedCornerTreatment\":\"com.google.android.material.shape.RoundedCornerTreatment\",\"android.support.design.shape.ShapePath\":\"com.google.android.material.shape.ShapePath\",\"android.support.design.shape.ShapePathModel\":\"com.google.android.material.shape.ShapePathModel\",\"android.support.design.shape.TriangleEdgeTreatment\":\"com.google.android.material.shape.TriangleEdgeTreatment\",\"android.support.design.snackbar.ContentViewCallback\":\"com.google.android.material.snackbar.ContentViewCallback\",\"android.support.design.stateful.ExtendableSavedState\":\"com.google.android.material.stateful.ExtendableSavedState\",\"android.support.design.theme.MaterialComponentsViewInflater\":\"com.google.android.material.theme.MaterialComponentsViewInflater\",\"android.support.design.transformation.ExpandableBehavior\":\"com.google.android.material.transformation.ExpandableBehavior\",\"android.support.design.transformation.ExpandableTransformationBehavior\":\"com.google.android.material.transformation.ExpandableTransformationBehavior\",\"android.support.design.transformation.FabTransformationBehavior\":\"com.google.android.material.transformation.FabTransformationBehavior\",\"android.support.design.transformation.FabTransformationScrimBehavior\":\"com.google.android.material.transformation.FabTransformationScrimBehavior\",\"android.support.design.transformation.FabTransformationSheetBehavior\":\"com.google.android.material.transformation.FabTransformationSheetBehavior\",\"android.support.design.transformation.TransformationChildCard\":\"com.google.android.material.transformation.TransformationChildCard\",\"android.support.design.transformation.TransformationChildLayout\":\"com.google.android.material.transformation.TransformationChildLayout\",\"android.support.design.widget.AppBarLayout\":\"com.google.android.material.appbar.AppBarLayout\",\"android.support.design.widget.BaseTransientBottomBar\":\"com.google.android.material.snackbar.BaseTransientBottomBar\",\"android.support.design.widget.BottomNavigationView\":\"com.google.android.material.bottomnavigation.BottomNavigationView\",\"android.support.design.widget.BottomSheetBehavior\":\"com.google.android.material.bottomsheet.BottomSheetBehavior\",\"android.support.design.widget.BottomSheetDialog\":\"com.google.android.material.bottomsheet.BottomSheetDialog\",\"android.support.design.widget.BottomSheetDialogFragment\":\"com.google.android.material.bottomsheet.BottomSheetDialogFragment\",\"android.support.design.widget.CheckableImageButton\":\"com.google.android.material.internal.CheckableImageButton\",\"android.support.design.widget.CircularBorderDrawable\":\"com.google.android.material.internal.CircularBorderDrawable\",\"android.support.design.widget.CircularBorderDrawableLollipop\":\"com.google.android.material.internal.CircularBorderDrawableLollipop\",\"android.support.design.widget.CollapsingTextHelper\":\"com.google.android.material.internal.CollapsingTextHelper\",\"android.support.design.widget.CollapsingToolbarLayout\":\"com.google.android.material.appbar.CollapsingToolbarLayout\",\"android.support.design.widget.CoordinatorLayout\":\"androidx.coordinatorlayout.widget.CoordinatorLayout\",\"android.support.design.widget.CutoutDrawable\":\"com.google.android.material.textfield.CutoutDrawable\",\"android.support.design.widget.DescendantOffsetUtils\":\"com.google.android.material.internal.DescendantOffsetUtils\",\"android.support.design.widget.DrawableUtils\":\"com.google.android.material.internal.DrawableUtils\",\"android.support.design.widget.FloatingActionButton\":\"com.google.android.material.floatingactionbutton.FloatingActionButton\",\"android.support.design.widget.FloatingActionButtonImpl\":\"com.google.android.material.floatingactionbutton.FloatingActionButtonImpl\",\"android.support.design.widget.FloatingActionButtonImplLollipop\":\"com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop\",\"android.support.design.widget.HeaderBehavior\":\"com.google.android.material.appbar.HeaderBehavior\",\"android.support.design.widget.HeaderScrollingViewBehavior\":\"com.google.android.material.appbar.HeaderScrollingViewBehavior\",\"android.support.design.widget.IndicatorViewController\":\"com.google.android.material.textfield.IndicatorViewController\",\"android.support.design.widget.MathUtils\":\"com.google.android.material.math.MathUtils\",\"android.support.design.widget.NavigationView\":\"com.google.android.material.navigation.NavigationView\",\"android.support.design.widget.ShadowDrawableWrapper\":\"com.google.android.material.shadow.ShadowDrawableWrapper\",\"android.support.design.widget.ShadowViewDelegate\":\"com.google.android.material.shadow.ShadowViewDelegate\",\"android.support.design.widget.Snackbar\":\"com.google.android.material.snackbar.Snackbar\",\"android.support.design.widget.SnackbarContentLayout\":\"com.google.android.material.snackbar.SnackbarContentLayout\",\"android.support.design.widget.SnackbarManager\":\"com.google.android.material.snackbar.SnackbarManager\",\"android.support.design.widget.StateListAnimator\":\"com.google.android.material.internal.StateListAnimator\",\"android.support.design.widget.SwipeDismissBehavior\":\"com.google.android.material.behavior.SwipeDismissBehavior\",\"android.support.design.widget.TabItem\":\"com.google.android.material.tabs.TabItem\",\"android.support.design.widget.TabLayout\":\"com.google.android.material.tabs.TabLayout\",\"android.support.design.widget.TextInputEditText\":\"com.google.android.material.textfield.TextInputEditText\",\"android.support.design.widget.TextInputLayout\":\"com.google.android.material.textfield.TextInputLayout\",\"android.support.design.widget.ViewOffsetBehavior\":\"com.google.android.material.appbar.ViewOffsetBehavior\",\"android.support.design.widget.ViewOffsetHelper\":\"com.google.android.material.appbar.ViewOffsetHelper\",\"android.support.design.widget.ViewUtilsLollipop\":\"com.google.android.material.appbar.ViewUtilsLollipop\",\"android.support.design.widget.VisibilityAwareImageButton\":\"com.google.android.material.internal.VisibilityAwareImageButton\",\"android.support.graphics.drawable.AndroidResources\":\"androidx.vectordrawable.graphics.drawable.AndroidResources\",\"android.support.graphics.drawable.Animatable2Compat\":\"androidx.vectordrawable.graphics.drawable.Animatable2Compat\",\"android.support.graphics.drawable.AnimatedVectorDrawableCompat\":\"androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat\",\"android.support.graphics.drawable.AnimationUtilsCompat\":\"androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat\",\"android.support.graphics.drawable.AnimatorInflaterCompat\":\"androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat\",\"android.support.graphics.drawable.ArgbEvaluator\":\"androidx.vectordrawable.graphics.drawable.ArgbEvaluator\",\"android.support.graphics.drawable.PathInterpolatorCompat\":\"androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat\",\"android.support.graphics.drawable.VectorDrawableCommon\":\"androidx.vectordrawable.graphics.drawable.VectorDrawableCommon\",\"android.support.graphics.drawable.VectorDrawableCompat\":\"androidx.vectordrawable.graphics.drawable.VectorDrawableCompat\",\"android.support.media.ExifInterface\":\"androidx.exifinterface.media.ExifInterface\",\"android.support.media.tv.BasePreviewProgram\":\"androidx.tvprovider.media.tv.BasePreviewProgram\",\"android.support.media.tv.BaseProgram\":\"androidx.tvprovider.media.tv.BaseProgram\",\"android.support.media.tv.Channel\":\"androidx.tvprovider.media.tv.Channel\",\"android.support.media.tv.ChannelLogoUtils\":\"androidx.tvprovider.media.tv.ChannelLogoUtils\",\"android.support.media.tv.CollectionUtils\":\"androidx.tvprovider.media.tv.CollectionUtils\",\"android.support.media.tv.PreviewChannel\":\"androidx.tvprovider.media.tv.PreviewChannel\",\"android.support.media.tv.PreviewChannelHelper\":\"androidx.tvprovider.media.tv.PreviewChannelHelper\",\"android.support.media.tv.PreviewProgram\":\"androidx.tvprovider.media.tv.PreviewProgram\",\"android.support.media.tv.Program\":\"androidx.tvprovider.media.tv.Program\",\"android.support.media.tv.TvContractCompat\":\"androidx.tvprovider.media.tv.TvContractCompat\",\"android.support.media.tv.TvContractUtils\":\"androidx.tvprovider.media.tv.TvContractUtils\",\"android.support.media.tv.WatchNextProgram\":\"androidx.tvprovider.media.tv.WatchNextProgram\",\"android.support.media2.BaseRemoteMediaPlayerConnector\":\"android.support.media2.BaseRemoteMediaPlayerConnector\",\"android.support.media2.DataSourceDesc2\":\"android.support.media2.DataSourceDesc2\",\"android.support.media2.MediaPlayerConnector\":\"android.support.media2.MediaPlayerConnector\",\"android.support.media2.MediaPlaylistAgent\":\"android.support.media2.MediaPlaylistAgent\",\"android.support.media2.MediaSession2\":\"android.support.media2.MediaSession2\",\"android.support.mediacompat.R\":\"androidx.media.R\",\"android.support.multidex.MultiDex\":\"androidx.multidex.MultiDex\",\"android.support.multidex.MultiDexApplication\":\"androidx.multidex.MultiDexApplication\",\"android.support.multidex.MultiDexExtractor\":\"androidx.multidex.MultiDexExtractor\",\"android.support.multidex.ZipUtil\":\"androidx.multidex.ZipUtil\",\"android.support.percent.PercentFrameLayout\":\"androidx.percentlayout.widget.PercentFrameLayout\",\"android.support.percent.PercentLayoutHelper\":\"androidx.percentlayout.widget.PercentLayoutHelper\",\"android.support.percent.PercentRelativeLayout\":\"androidx.percentlayout.widget.PercentRelativeLayout\",\"android.support.percent.R\":\"androidx.percentlayout.R\",\"android.support.test.annotation.Beta\":\"androidx.test.annotation.Beta\",\"android.support.test.annotation.UiThreadTest\":\"androidx.test.annotation.UiThreadTest\",\"android.support.test.espresso.accessibility.AccessibilityChecks\":\"androidx.test.espresso.accessibility.AccessibilityChecks\",\"android.support.test.espresso.action.AdapterDataLoaderAction\":\"androidx.test.espresso.action.AdapterDataLoaderAction\",\"android.support.test.espresso.action.AdapterDataLoaderActionRemoteMsg\":\"androidx.test.espresso.action.AdapterDataLoaderActionRemoteMsg\",\"android.support.test.espresso.action.AdapterViewProtocol\":\"androidx.test.espresso.action.AdapterViewProtocol\",\"android.support.test.espresso.action.AdapterViewProtocols\":\"androidx.test.espresso.action.AdapterViewProtocols\",\"android.support.test.espresso.action.CloseKeyboardAction\":\"androidx.test.espresso.action.CloseKeyboardAction\",\"android.support.test.espresso.action.CoordinatesProvider\":\"androidx.test.espresso.action.CoordinatesProvider\",\"android.support.test.espresso.action.EditorAction\":\"androidx.test.espresso.action.EditorAction\",\"android.support.test.espresso.action.EspressoKey\":\"androidx.test.espresso.action.EspressoKey\",\"android.support.test.espresso.action.GeneralClickAction\":\"androidx.test.espresso.action.GeneralClickAction\",\"android.support.test.espresso.action.GeneralClickActionRemoteMessage\":\"androidx.test.espresso.action.GeneralClickActionRemoteMessage\",\"android.support.test.espresso.action.GeneralLocation\":\"androidx.test.espresso.action.GeneralLocation\",\"android.support.test.espresso.action.GeneralLocationRemoteMessage\":\"androidx.test.espresso.action.GeneralLocationRemoteMessage\",\"android.support.test.espresso.action.GeneralSwipeAction\":\"androidx.test.espresso.action.GeneralSwipeAction\",\"android.support.test.espresso.action.GeneralSwipeActionRemoteMessage\":\"androidx.test.espresso.action.GeneralSwipeActionRemoteMessage\",\"android.support.test.espresso.action.KeyEventAction\":\"androidx.test.espresso.action.KeyEventAction\",\"android.support.test.espresso.action.KeyEventActionBase\":\"androidx.test.espresso.action.KeyEventActionBase\",\"android.support.test.espresso.action.MotionEvents\":\"androidx.test.espresso.action.MotionEvents\",\"android.support.test.espresso.action.OpenLinkAction\":\"androidx.test.espresso.action.OpenLinkAction\",\"android.support.test.espresso.action.PrecisionDescriber\":\"androidx.test.espresso.action.PrecisionDescriber\",\"android.support.test.espresso.action.Press\":\"androidx.test.espresso.action.Press\",\"android.support.test.espresso.action.PressBackAction\":\"androidx.test.espresso.action.PressBackAction\",\"android.support.test.espresso.action.PressRemoteMessage\":\"androidx.test.espresso.action.PressRemoteMessage\",\"android.support.test.espresso.action.RemoteViewActions\":\"androidx.test.espresso.action.RemoteViewActions\",\"android.support.test.espresso.action.RepeatActionUntilViewState\":\"androidx.test.espresso.action.RepeatActionUntilViewState\",\"android.support.test.espresso.action.ReplaceTextAction\":\"androidx.test.espresso.action.ReplaceTextAction\",\"android.support.test.espresso.action.ScrollToAction\":\"androidx.test.espresso.action.ScrollToAction\",\"android.support.test.espresso.action.Swipe\":\"androidx.test.espresso.action.Swipe\",\"android.support.test.espresso.action.Swiper\":\"androidx.test.espresso.action.Swiper\",\"android.support.test.espresso.action.SwipeRemoteMessage\":\"androidx.test.espresso.action.SwipeRemoteMessage\",\"android.support.test.espresso.action.Tap\":\"androidx.test.espresso.action.Tap\",\"android.support.test.espresso.action.Tapper\":\"androidx.test.espresso.action.Tapper\",\"android.support.test.espresso.action.TapRemoteMessage\":\"androidx.test.espresso.action.TapRemoteMessage\",\"android.support.test.espresso.action.TranslatedCoordinatesProvider\":\"androidx.test.espresso.action.TranslatedCoordinatesProvider\",\"android.support.test.espresso.action.TranslatedCoordinatesProviderRemoteMessage\":\"androidx.test.espresso.action.TranslatedCoordinatesProviderRemoteMessage\",\"android.support.test.espresso.action.TypeTextAction\":\"androidx.test.espresso.action.TypeTextAction\",\"android.support.test.espresso.action.ViewActions\":\"androidx.test.espresso.action.ViewActions\",\"android.support.test.espresso.AmbiguousViewMatcherException\":\"androidx.test.espresso.AmbiguousViewMatcherException\",\"android.support.test.espresso.AppNotIdleException\":\"androidx.test.espresso.AppNotIdleException\",\"android.support.test.espresso.assertion.LayoutAssertions\":\"androidx.test.espresso.assertion.LayoutAssertions\",\"android.support.test.espresso.assertion.PositionAssertions\":\"androidx.test.espresso.assertion.PositionAssertions\",\"android.support.test.espresso.assertion.RemoteViewAssertions\":\"androidx.test.espresso.assertion.RemoteViewAssertions\",\"android.support.test.espresso.assertion.ViewAssertions\":\"androidx.test.espresso.assertion.ViewAssertions\",\"android.support.test.espresso.base.ActiveRootLister\":\"androidx.test.espresso.base.ActiveRootLister\",\"android.support.test.espresso.base.AsyncTaskPoolMonitor\":\"androidx.test.espresso.base.AsyncTaskPoolMonitor\",\"android.support.test.espresso.base.BaseLayerModule\":\"androidx.test.espresso.base.BaseLayerModule\",\"android.support.test.espresso.base.BaseLayerModule_FailureHandlerHolder_Factory\":\"androidx.test.espresso.base.BaseLayerModule_FailureHandlerHolder_Factory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideActiveRootListerFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideActiveRootListerFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideDynamicNotiferFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideDynamicNotiferFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideEventInjectorFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideEventInjectorFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideFailureHanderFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideFailureHanderFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideFailureHandlerFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideFailureHandlerFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideLifecycleMonitorFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideLifecycleMonitorFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideMainLooperFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideMainLooperFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideMainThreadExecutorFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideMainThreadExecutorFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideRemoteExecutorFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideRemoteExecutorFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory\",\"android.support.test.espresso.base.BaseLayerModule_ProvideTargetContextFactory\":\"androidx.test.espresso.base.BaseLayerModule_ProvideTargetContextFactory\",\"android.support.test.espresso.base.CompatAsyncTask\":\"androidx.test.espresso.base.CompatAsyncTask\",\"android.support.test.espresso.base.Default\":\"androidx.test.espresso.base.Default\",\"android.support.test.espresso.base.DefaultFailureHandler\":\"androidx.test.espresso.base.DefaultFailureHandler\",\"android.support.test.espresso.base.EventInjectionStrategy\":\"androidx.test.espresso.base.EventInjectionStrategy\",\"android.support.test.espresso.base.EventInjector\":\"androidx.test.espresso.base.EventInjector\",\"android.support.test.espresso.base.IdleNotifier\":\"androidx.test.espresso.base.IdleNotifier\",\"android.support.test.espresso.base.IdlingResourceRegistry\":\"androidx.test.espresso.base.IdlingResourceRegistry\",\"android.support.test.espresso.base.IdlingResourceRegistry_Factory\":\"androidx.test.espresso.base.IdlingResourceRegistry_Factory\",\"android.support.test.espresso.base.IdlingUiController\":\"androidx.test.espresso.base.IdlingUiController\",\"android.support.test.espresso.base.InputManagerEventInjectionStrategy\":\"androidx.test.espresso.base.InputManagerEventInjectionStrategy\",\"android.support.test.espresso.base.Interrogator\":\"androidx.test.espresso.base.Interrogator\",\"android.support.test.espresso.base.InterruptableUiController\":\"androidx.test.espresso.base.InterruptableUiController\",\"android.support.test.espresso.base.LooperIdlingResourceInterrogationHandler\":\"androidx.test.espresso.base.LooperIdlingResourceInterrogationHandler\",\"android.support.test.espresso.base.MainThread\":\"androidx.test.espresso.base.MainThread\",\"android.support.test.espresso.base.NoopIdleNotificationCallbackIdleNotifierProvider\":\"androidx.test.espresso.base.NoopIdleNotificationCallbackIdleNotifierProvider\",\"android.support.test.espresso.base.NoopRunnableIdleNotifier\":\"androidx.test.espresso.base.NoopRunnableIdleNotifier\",\"android.support.test.espresso.base.RootsOracle\":\"androidx.test.espresso.base.RootsOracle\",\"android.support.test.espresso.base.RootsOracle_Factory\":\"androidx.test.espresso.base.RootsOracle_Factory\",\"android.support.test.espresso.base.RootViewPicker\":\"androidx.test.espresso.base.RootViewPicker\",\"android.support.test.espresso.base.RootViewPicker_Factory\":\"androidx.test.espresso.base.RootViewPicker_Factory\",\"android.support.test.espresso.base.RootViewPicker_RootResultFetcher_Factory\":\"androidx.test.espresso.base.RootViewPicker_RootResultFetcher_Factory\",\"android.support.test.espresso.base.RootViewPickerScope\":\"androidx.test.espresso.base.RootViewPickerScope\",\"android.support.test.espresso.base.SdkAsyncTask\":\"androidx.test.espresso.base.SdkAsyncTask\",\"android.support.test.espresso.base.ThreadPoolExecutorExtractor\":\"androidx.test.espresso.base.ThreadPoolExecutorExtractor\",\"android.support.test.espresso.base.ThreadPoolExecutorExtractor_Factory\":\"androidx.test.espresso.base.ThreadPoolExecutorExtractor_Factory\",\"android.support.test.espresso.base.UiControllerImpl\":\"androidx.test.espresso.base.UiControllerImpl\",\"android.support.test.espresso.base.UiControllerImpl_Factory\":\"androidx.test.espresso.base.UiControllerImpl_Factory\",\"android.support.test.espresso.base.UiControllerModule\":\"androidx.test.espresso.base.UiControllerModule\",\"android.support.test.espresso.base.ViewFinderImpl\":\"androidx.test.espresso.base.ViewFinderImpl\",\"android.support.test.espresso.base.ViewFinderImpl_Factory\":\"androidx.test.espresso.base.ViewFinderImpl_Factory\",\"android.support.test.espresso.base.WindowManagerEventInjectionStrategy\":\"androidx.test.espresso.base.WindowManagerEventInjectionStrategy\",\"android.support.test.espresso.BaseLayerComponent\":\"androidx.test.espresso.BaseLayerComponent\",\"android.support.test.espresso.contrib.AccessibilityChecks\":\"androidx.test.espresso.contrib.AccessibilityChecks\",\"android.support.test.espresso.contrib.ActivityResultMatchers\":\"androidx.test.espresso.contrib.ActivityResultMatchers\",\"android.support.test.espresso.contrib.Checks\":\"androidx.test.espresso.contrib.Checks\",\"android.support.test.espresso.contrib.DrawerActions\":\"androidx.test.espresso.contrib.DrawerActions\",\"android.support.test.espresso.contrib.DrawerMatchers\":\"androidx.test.espresso.contrib.DrawerMatchers\",\"android.support.test.espresso.contrib.NavigationViewActions\":\"androidx.test.espresso.contrib.NavigationViewActions\",\"android.support.test.espresso.contrib.PickerActions\":\"androidx.test.espresso.contrib.PickerActions\",\"android.support.test.espresso.contrib.RecyclerViewActions\":\"androidx.test.espresso.contrib.RecyclerViewActions\",\"android.support.test.espresso.contrib.ViewPagerActions\":\"androidx.test.espresso.contrib.ViewPagerActions\",\"android.support.test.espresso.DaggerBaseLayerComponent\":\"androidx.test.espresso.DaggerBaseLayerComponent\",\"android.support.test.espresso.DataInteraction\":\"androidx.test.espresso.DataInteraction\",\"android.support.test.espresso.DataInteractionRemote\":\"androidx.test.espresso.DataInteractionRemote\",\"android.support.test.espresso.Espresso\":\"androidx.test.espresso.Espresso\",\"android.support.test.espresso.EspressoException\":\"androidx.test.espresso.EspressoException\",\"android.support.test.espresso.FailureHandler\":\"androidx.test.espresso.FailureHandler\",\"android.support.test.espresso.GraphHolder\":\"androidx.test.espresso.GraphHolder\",\"android.support.test.espresso.idling.concurrent.IdlingScheduledThreadPoolExecutor\":\"androidx.test.espresso.idling.concurrent.IdlingScheduledThreadPoolExecutor\",\"android.support.test.espresso.idling.concurrent.IdlingThreadPoolExecutor\":\"androidx.test.espresso.idling.concurrent.IdlingThreadPoolExecutor\",\"android.support.test.espresso.idling.CountingIdlingResource\":\"androidx.test.espresso.idling.CountingIdlingResource\",\"android.support.test.espresso.idling.net.UriIdlingResource\":\"androidx.test.espresso.idling.net.UriIdlingResource\",\"android.support.test.espresso.IdlingPolicies\":\"androidx.test.espresso.IdlingPolicies\",\"android.support.test.espresso.IdlingPolicy\":\"androidx.test.espresso.IdlingPolicy\",\"android.support.test.espresso.IdlingRegistry\":\"androidx.test.espresso.IdlingRegistry\",\"android.support.test.espresso.IdlingResource\":\"androidx.test.espresso.IdlingResource\",\"android.support.test.espresso.IdlingResourceTimeoutException\":\"androidx.test.espresso.IdlingResourceTimeoutException\",\"android.support.test.espresso.InjectEventSecurityException\":\"androidx.test.espresso.InjectEventSecurityException\",\"android.support.test.espresso.intent.ActivityResultFunction\":\"androidx.test.espresso.intent.ActivityResultFunction\",\"android.support.test.espresso.intent.Checks\":\"androidx.test.espresso.intent.Checks\",\"android.support.test.espresso.intent.Intents\":\"androidx.test.espresso.intent.Intents\",\"android.support.test.espresso.intent.matcher.BundleMatchers\":\"androidx.test.espresso.intent.matcher.BundleMatchers\",\"android.support.test.espresso.intent.matcher.ComponentNameMatchers\":\"androidx.test.espresso.intent.matcher.ComponentNameMatchers\",\"android.support.test.espresso.intent.matcher.IntentMatchers\":\"androidx.test.espresso.intent.matcher.IntentMatchers\",\"android.support.test.espresso.intent.matcher.UriMatchers\":\"androidx.test.espresso.intent.matcher.UriMatchers\",\"android.support.test.espresso.intent.OngoingStubbing\":\"androidx.test.espresso.intent.OngoingStubbing\",\"android.support.test.espresso.intent.ResettingStubber\":\"androidx.test.espresso.intent.ResettingStubber\",\"android.support.test.espresso.intent.ResettingStubberImpl\":\"androidx.test.espresso.intent.ResettingStubberImpl\",\"android.support.test.espresso.intent.ResolvedIntent\":\"androidx.test.espresso.intent.ResolvedIntent\",\"android.support.test.espresso.intent.ResolvedIntentImpl\":\"androidx.test.espresso.intent.ResolvedIntentImpl\",\"android.support.test.espresso.intent.rule.IntentsTestRule\":\"androidx.test.espresso.intent.rule.IntentsTestRule\",\"android.support.test.espresso.intent.VerifiableIntent\":\"androidx.test.espresso.intent.VerifiableIntent\",\"android.support.test.espresso.intent.VerifiableIntentImpl\":\"androidx.test.espresso.intent.VerifiableIntentImpl\",\"android.support.test.espresso.intent.VerificationMode\":\"androidx.test.espresso.intent.VerificationMode\",\"android.support.test.espresso.intent.VerificationModes\":\"androidx.test.espresso.intent.VerificationModes\",\"android.support.test.espresso.InteractionResultsHandler\":\"androidx.test.espresso.InteractionResultsHandler\",\"android.support.test.espresso.matcher.BoundedMatcher\":\"androidx.test.espresso.matcher.BoundedMatcher\",\"android.support.test.espresso.matcher.CursorMatchers\":\"androidx.test.espresso.matcher.CursorMatchers\",\"android.support.test.espresso.matcher.HasBackgroundMatcher\":\"androidx.test.espresso.matcher.HasBackgroundMatcher\",\"android.support.test.espresso.matcher.LayoutMatchers\":\"androidx.test.espresso.matcher.LayoutMatchers\",\"android.support.test.espresso.matcher.PreferenceMatchers\":\"androidx.test.espresso.matcher.PreferenceMatchers\",\"android.support.test.espresso.matcher.RemoteHamcrestCoreMatchers13\":\"androidx.test.espresso.matcher.RemoteHamcrestCoreMatchers13\",\"android.support.test.espresso.matcher.RemoteRootMatchers\":\"androidx.test.espresso.matcher.RemoteRootMatchers\",\"android.support.test.espresso.matcher.RemoteViewMatchers\":\"androidx.test.espresso.matcher.RemoteViewMatchers\",\"android.support.test.espresso.matcher.RootMatchers\":\"androidx.test.espresso.matcher.RootMatchers\",\"android.support.test.espresso.matcher.ViewMatchers\":\"androidx.test.espresso.matcher.ViewMatchers\",\"android.support.test.espresso.NoActivityResumedException\":\"androidx.test.espresso.NoActivityResumedException\",\"android.support.test.espresso.NoMatchingRootException\":\"androidx.test.espresso.NoMatchingRootException\",\"android.support.test.espresso.NoMatchingViewException\":\"androidx.test.espresso.NoMatchingViewException\",\"android.support.test.espresso.PerformException\":\"androidx.test.espresso.PerformException\",\"android.support.test.espresso.proto.action.ViewActions\":\"androidx.test.espresso.proto.action.ViewActions\",\"android.support.test.espresso.proto.assertion.ViewAssertions\":\"androidx.test.espresso.proto.assertion.ViewAssertions\",\"android.support.test.espresso.proto.matcher.RootMatchers\":\"androidx.test.espresso.proto.matcher.RootMatchers\",\"android.support.test.espresso.proto.matcher.ViewMatchers\":\"androidx.test.espresso.proto.matcher.ViewMatchers\",\"android.support.test.espresso.proto.matcher13.HamcrestMatchersv13\":\"androidx.test.espresso.proto.matcher13.HamcrestMatchersv13\",\"android.support.test.espresso.proto.UiInteraction\":\"androidx.test.espresso.proto.UiInteraction\",\"android.support.test.espresso.remote.annotation.RemoteMsgConstructor\":\"androidx.test.espresso.remote.annotation.RemoteMsgConstructor\",\"android.support.test.espresso.remote.annotation.RemoteMsgField\":\"androidx.test.espresso.remote.annotation.RemoteMsgField\",\"android.support.test.espresso.remote.AnyToTypeConverter\":\"androidx.test.espresso.remote.AnyToTypeConverter\",\"android.support.test.espresso.remote.Bindable\":\"androidx.test.espresso.remote.Bindable\",\"android.support.test.espresso.remote.BuilderReflector\":\"androidx.test.espresso.remote.BuilderReflector\",\"android.support.test.espresso.remote.ByteStringToParcelableConverter\":\"androidx.test.espresso.remote.ByteStringToParcelableConverter\",\"android.support.test.espresso.remote.ByteStringToTypeConverter\":\"androidx.test.espresso.remote.ByteStringToTypeConverter\",\"android.support.test.espresso.remote.ConstructorInvocation\":\"androidx.test.espresso.remote.ConstructorInvocation\",\"android.support.test.espresso.remote.Converter\":\"androidx.test.espresso.remote.Converter\",\"android.support.test.espresso.remote.EspressoRemote\":\"androidx.test.espresso.remote.EspressoRemote\",\"android.support.test.espresso.remote.EspressoRemoteMessage\":\"androidx.test.espresso.remote.EspressoRemoteMessage\",\"android.support.test.espresso.remote.FieldDescriptor\":\"androidx.test.espresso.remote.FieldDescriptor\",\"android.support.test.espresso.remote.GenericRemoteMessage\":\"androidx.test.espresso.remote.GenericRemoteMessage\",\"android.support.test.espresso.remote.IInteractionExecutionStatus\":\"androidx.test.espresso.remote.IInteractionExecutionStatus\",\"android.support.test.espresso.remote.InteractionRequest\":\"androidx.test.espresso.remote.InteractionRequest\",\"android.support.test.espresso.remote.InteractionResponse\":\"androidx.test.espresso.remote.InteractionResponse\",\"android.support.test.espresso.remote.MethodInvocation\":\"androidx.test.espresso.remote.MethodInvocation\",\"android.support.test.espresso.remote.NoopRemoteInteraction\":\"androidx.test.espresso.remote.NoopRemoteInteraction\",\"android.support.test.espresso.remote.NoRemoteEspressoInstanceException\":\"androidx.test.espresso.remote.NoRemoteEspressoInstanceException\",\"android.support.test.espresso.remote.ParcelableToByteStringConverter\":\"androidx.test.espresso.remote.ParcelableToByteStringConverter\",\"android.support.test.espresso.remote.ProtoReflector\":\"androidx.test.espresso.remote.ProtoReflector\",\"android.support.test.espresso.remote.ProtoUtils\":\"androidx.test.espresso.remote.ProtoUtils\",\"android.support.test.espresso.remote.RemoteDescriptor\":\"androidx.test.espresso.remote.RemoteDescriptor\",\"android.support.test.espresso.remote.RemoteDescriptorRegistry\":\"androidx.test.espresso.remote.RemoteDescriptorRegistry\",\"android.support.test.espresso.remote.RemoteEspressoException\":\"androidx.test.espresso.remote.RemoteEspressoException\",\"android.support.test.espresso.remote.RemoteInteraction\":\"androidx.test.espresso.remote.RemoteInteraction\",\"android.support.test.espresso.remote.RemoteInteractionRegistry\":\"androidx.test.espresso.remote.RemoteInteractionRegistry\",\"android.support.test.espresso.remote.RemoteMessageDeserializer\":\"androidx.test.espresso.remote.RemoteMessageDeserializer\",\"android.support.test.espresso.remote.RemoteMessageSerializer\":\"androidx.test.espresso.remote.RemoteMessageSerializer\",\"android.support.test.espresso.remote.RemoteProtocolException\":\"androidx.test.espresso.remote.RemoteProtocolException\",\"android.support.test.espresso.remote.TypeProtoConverters\":\"androidx.test.espresso.remote.TypeProtoConverters\",\"android.support.test.espresso.remote.TypeToAnyConverter\":\"androidx.test.espresso.remote.TypeToAnyConverter\",\"android.support.test.espresso.remote.TypeToByteStringConverter\":\"androidx.test.espresso.remote.TypeToByteStringConverter\",\"android.support.test.espresso.Root\":\"androidx.test.espresso.Root\",\"android.support.test.espresso.UiController\":\"androidx.test.espresso.UiController\",\"android.support.test.espresso.util.ActivityLifecycles\":\"androidx.test.espresso.util.ActivityLifecycles\",\"android.support.test.espresso.util.EspressoOptional\":\"androidx.test.espresso.util.EspressoOptional\",\"android.support.test.espresso.util.HumanReadables\":\"androidx.test.espresso.util.HumanReadables\",\"android.support.test.espresso.util.TreeIterables\":\"androidx.test.espresso.util.TreeIterables\",\"android.support.test.espresso.ViewAction\":\"androidx.test.espresso.ViewAction\",\"android.support.test.espresso.ViewAssertion\":\"androidx.test.espresso.ViewAssertion\",\"android.support.test.espresso.ViewFinder\":\"androidx.test.espresso.ViewFinder\",\"android.support.test.espresso.ViewInteraction\":\"androidx.test.espresso.ViewInteraction\",\"android.support.test.espresso.ViewInteraction_Factory\":\"androidx.test.espresso.ViewInteraction_Factory\",\"android.support.test.espresso.ViewInteractionComponent\":\"androidx.test.espresso.ViewInteractionComponent\",\"android.support.test.espresso.ViewInteractionModule\":\"androidx.test.espresso.ViewInteractionModule\",\"android.support.test.espresso.ViewInteractionModule_ProvideNeedsActivityFactory\":\"androidx.test.espresso.ViewInteractionModule_ProvideNeedsActivityFactory\",\"android.support.test.espresso.ViewInteractionModule_ProvideRemoteInteractionFactory\":\"androidx.test.espresso.ViewInteractionModule_ProvideRemoteInteractionFactory\",\"android.support.test.espresso.ViewInteractionModule_ProvideRootMatcherFactory\":\"androidx.test.espresso.ViewInteractionModule_ProvideRootMatcherFactory\",\"android.support.test.espresso.ViewInteractionModule_ProvideRootViewFactory\":\"androidx.test.espresso.ViewInteractionModule_ProvideRootViewFactory\",\"android.support.test.espresso.ViewInteractionModule_ProvideViewFinderFactory\":\"androidx.test.espresso.ViewInteractionModule_ProvideViewFinderFactory\",\"android.support.test.espresso.ViewInteractionModule_ProvideViewMatcherFactory\":\"androidx.test.espresso.ViewInteractionModule_ProvideViewMatcherFactory\",\"android.support.test.espresso.web.action.AtomAction\":\"androidx.test.espresso.web.action.AtomAction\",\"android.support.test.espresso.web.action.AtomActionRemoteMessage\":\"androidx.test.espresso.web.action.AtomActionRemoteMessage\",\"android.support.test.espresso.web.action.EnableJavascriptAction\":\"androidx.test.espresso.web.action.EnableJavascriptAction\",\"android.support.test.espresso.web.action.EvaluationAtom\":\"androidx.test.espresso.web.action.EvaluationAtom\",\"android.support.test.espresso.web.action.IAtomActionResultPropagator\":\"androidx.test.espresso.web.action.IAtomActionResultPropagator\",\"android.support.test.espresso.web.action.JavascriptEvaluation\":\"androidx.test.espresso.web.action.JavascriptEvaluation\",\"android.support.test.espresso.web.action.RemoteWebActions\":\"androidx.test.espresso.web.action.RemoteWebActions\",\"android.support.test.espresso.web.assertion.ByteStringToDocumentConverter\":\"androidx.test.espresso.web.assertion.ByteStringToDocumentConverter\",\"android.support.test.espresso.web.assertion.CheckResultWebAssertionRemoteMessage\":\"androidx.test.espresso.web.assertion.CheckResultWebAssertionRemoteMessage\",\"android.support.test.espresso.web.assertion.CompressorDecompressor\":\"androidx.test.espresso.web.assertion.CompressorDecompressor\",\"android.support.test.espresso.web.assertion.DocumentProtoConverters\":\"androidx.test.espresso.web.assertion.DocumentProtoConverters\",\"android.support.test.espresso.web.assertion.DocumentToByteStringConverter\":\"androidx.test.espresso.web.assertion.DocumentToByteStringConverter\",\"android.support.test.espresso.web.assertion.RemoteWebViewAssertions\":\"androidx.test.espresso.web.assertion.RemoteWebViewAssertions\",\"android.support.test.espresso.web.assertion.TagSoupDocumentParser\":\"androidx.test.espresso.web.assertion.TagSoupDocumentParser\",\"android.support.test.espresso.web.assertion.WebAssertion\":\"androidx.test.espresso.web.assertion.WebAssertion\",\"android.support.test.espresso.web.assertion.WebViewAssertions\":\"androidx.test.espresso.web.assertion.WebViewAssertions\",\"android.support.test.espresso.web.matcher.AmbiguousElementMatcherException\":\"androidx.test.espresso.web.matcher.AmbiguousElementMatcherException\",\"android.support.test.espresso.web.matcher.DomMatchers\":\"androidx.test.espresso.web.matcher.DomMatchers\",\"android.support.test.espresso.web.matcher.RemoteWebMatchers\":\"androidx.test.espresso.web.matcher.RemoteWebMatchers\",\"android.support.test.espresso.web.model.Atom\":\"androidx.test.espresso.web.model.Atom\",\"android.support.test.espresso.web.model.Atoms\":\"androidx.test.espresso.web.model.Atoms\",\"android.support.test.espresso.web.model.ElementReference\":\"androidx.test.espresso.web.model.ElementReference\",\"android.support.test.espresso.web.model.Evaluation\":\"androidx.test.espresso.web.model.Evaluation\",\"android.support.test.espresso.web.model.JSONAble\":\"androidx.test.espresso.web.model.JSONAble\",\"android.support.test.espresso.web.model.ModelCodec\":\"androidx.test.espresso.web.model.ModelCodec\",\"android.support.test.espresso.web.model.RemoteWebModelAtoms\":\"androidx.test.espresso.web.model.RemoteWebModelAtoms\",\"android.support.test.espresso.web.model.ScriptWithArgsSimpleAtomRemoteMessage\":\"androidx.test.espresso.web.model.ScriptWithArgsSimpleAtomRemoteMessage\",\"android.support.test.espresso.web.model.SimpleAtom\":\"androidx.test.espresso.web.model.SimpleAtom\",\"android.support.test.espresso.web.model.TransformingAtom\":\"androidx.test.espresso.web.model.TransformingAtom\",\"android.support.test.espresso.web.model.WindowReference\":\"androidx.test.espresso.web.model.WindowReference\",\"android.support.test.espresso.web.proto.action.WebActions\":\"androidx.test.espresso.web.proto.action.WebActions\",\"android.support.test.espresso.web.proto.assertion.WebAssertions\":\"androidx.test.espresso.web.proto.assertion.WebAssertions\",\"android.support.test.espresso.web.proto.matcher.RemoteWebMatchers\":\"androidx.test.espresso.web.proto.matcher.RemoteWebMatchers\",\"android.support.test.espresso.web.proto.model.WebModelAtoms\":\"androidx.test.espresso.web.proto.model.WebModelAtoms\",\"android.support.test.espresso.web.proto.sugar.WebSugar\":\"androidx.test.espresso.web.proto.sugar.WebSugar\",\"android.support.test.espresso.web.proto.webdriver.WebWebdriverAtoms\":\"androidx.test.espresso.web.proto.webdriver.WebWebdriverAtoms\",\"android.support.test.espresso.web.sugar.RemoteWebSugar\":\"androidx.test.espresso.web.sugar.RemoteWebSugar\",\"android.support.test.espresso.web.sugar.Web\":\"androidx.test.espresso.web.sugar.Web\",\"android.support.test.espresso.web.webdriver.DriverAtoms\":\"androidx.test.espresso.web.webdriver.DriverAtoms\",\"android.support.test.espresso.web.webdriver.Locator\":\"androidx.test.espresso.web.webdriver.Locator\",\"android.support.test.espresso.web.webdriver.RemoteWebDriverAtoms\":\"androidx.test.espresso.web.webdriver.RemoteWebDriverAtoms\",\"android.support.test.espresso.web.webdriver.WebDriverAtomScripts\":\"androidx.test.espresso.web.webdriver.WebDriverAtomScripts\",\"android.support.test.filters.FlakyTest\":\"androidx.test.filters.FlakyTest\",\"android.support.test.filters.LargeTest\":\"androidx.test.filters.LargeTest\",\"android.support.test.filters.MediumTest\":\"androidx.test.filters.MediumTest\",\"android.support.test.filters.RequiresDevice\":\"androidx.test.filters.RequiresDevice\",\"android.support.test.filters.SdkSuppress\":\"androidx.test.filters.SdkSuppress\",\"android.support.test.filters.SmallTest\":\"androidx.test.filters.SmallTest\",\"android.support.test.filters.Suppress\":\"androidx.test.filters.Suppress\",\"android.support.test.InstrumentationRegistry\":\"androidx.test.InstrumentationRegistry\",\"android.support.test.jank.GfxMonitor\":\"androidx.test.jank.GfxMonitor\",\"android.support.test.jank.JankTest\":\"androidx.test.jank.JankTest\",\"android.support.test.jank.JankTestBase\":\"androidx.test.jank.JankTestBase\",\"android.support.test.jank.WindowAnimationFrameStatsMonitor\":\"androidx.test.jank.WindowAnimationFrameStatsMonitor\",\"android.support.test.jank.WindowContentFrameStatsMonitor\":\"androidx.test.jank.WindowContentFrameStatsMonitor\",\"android.support.test.orchestrator.callback.OrchestratorCallback\":\"androidx.test.orchestrator.callback.OrchestratorCallback\",\"android.support.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener\":\"androidx.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener\",\"android.support.test.orchestrator.junit.BundleJUnitUtils\":\"androidx.test.orchestrator.junit.BundleJUnitUtils\",\"android.support.test.orchestrator.junit.ParcelableDescription\":\"androidx.test.orchestrator.junit.ParcelableDescription\",\"android.support.test.orchestrator.junit.ParcelableFailure\":\"androidx.test.orchestrator.junit.ParcelableFailure\",\"android.support.test.orchestrator.junit.ParcelableResult\":\"androidx.test.orchestrator.junit.ParcelableResult\",\"android.support.test.orchestrator.listeners.OrchestrationListenerManager\":\"androidx.test.orchestrator.listeners.OrchestrationListenerManager\",\"android.support.test.orchestrator.listeners.OrchestrationRunListener\":\"androidx.test.orchestrator.listeners.OrchestrationRunListener\",\"android.support.test.orchestrator.listeners.result.ITestRunListener\":\"androidx.test.orchestrator.listeners.result.ITestRunListener\",\"android.support.test.orchestrator.listeners.result.TestIdentifier\":\"androidx.test.orchestrator.listeners.result.TestIdentifier\",\"android.support.test.orchestrator.listeners.result.TestResult\":\"androidx.test.orchestrator.listeners.result.TestResult\",\"android.support.test.orchestrator.listeners.result.TestRunResult\":\"androidx.test.orchestrator.listeners.result.TestRunResult\",\"android.support.test.rule.ActivityTestRule\":\"androidx.test.rule.ActivityTestRule\",\"android.support.test.rule.DisableOnAndroidDebug\":\"androidx.test.rule.DisableOnAndroidDebug\",\"android.support.test.rule.GrantPermissionRule\":\"androidx.test.rule.GrantPermissionRule\",\"android.support.test.rule.logging.AtraceLogger\":\"androidx.test.rule.logging.AtraceLogger\",\"android.support.test.rule.PortForwardingRule\":\"androidx.test.rule.PortForwardingRule\",\"android.support.test.rule.provider.DatabaseArgs\":\"androidx.test.rule.provider.DatabaseArgs\",\"android.support.test.rule.provider.DelegatingContext\":\"androidx.test.rule.provider.DelegatingContext\",\"android.support.test.rule.provider.ProviderArgs\":\"androidx.test.rule.provider.ProviderArgs\",\"android.support.test.rule.provider.ProviderTestRule\":\"androidx.test.rule.provider.ProviderTestRule\",\"android.support.test.rule.ServiceTestRule\":\"androidx.test.rule.ServiceTestRule\",\"android.support.test.rule.UiThreadTestRule\":\"androidx.test.rule.UiThreadTestRule\",\"android.support.test.runner.AndroidJUnit4\":\"androidx.test.runner.AndroidJUnit4\",\"android.support.test.runner.AndroidJUnitRunner\":\"androidx.test.runner.AndroidJUnitRunner\",\"android.support.test.runner.intent.IntentCallback\":\"androidx.test.runner.intent.IntentCallback\",\"android.support.test.runner.intent.IntentMonitor\":\"androidx.test.runner.intent.IntentMonitor\",\"android.support.test.runner.intent.IntentMonitorRegistry\":\"androidx.test.runner.intent.IntentMonitorRegistry\",\"android.support.test.runner.intent.IntentStubber\":\"androidx.test.runner.intent.IntentStubber\",\"android.support.test.runner.intent.IntentStubberRegistry\":\"androidx.test.runner.intent.IntentStubberRegistry\",\"android.support.test.runner.intercepting.InterceptingActivityFactory\":\"androidx.test.runner.intercepting.InterceptingActivityFactory\",\"android.support.test.runner.intercepting.SingleActivityFactory\":\"androidx.test.runner.intercepting.SingleActivityFactory\",\"android.support.test.runner.lifecycle.ActivityLifecycleCallback\":\"androidx.test.runner.lifecycle.ActivityLifecycleCallback\",\"android.support.test.runner.lifecycle.ActivityLifecycleMonitor\":\"androidx.test.runner.lifecycle.ActivityLifecycleMonitor\",\"android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry\":\"androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry\",\"android.support.test.runner.lifecycle.ApplicationLifecycleCallback\":\"androidx.test.runner.lifecycle.ApplicationLifecycleCallback\",\"android.support.test.runner.lifecycle.ApplicationLifecycleMonitor\":\"androidx.test.runner.lifecycle.ApplicationLifecycleMonitor\",\"android.support.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry\":\"androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry\",\"android.support.test.runner.lifecycle.ApplicationStage\":\"androidx.test.runner.lifecycle.ApplicationStage\",\"android.support.test.runner.lifecycle.Stage\":\"androidx.test.runner.lifecycle.Stage\",\"android.support.test.runner.MonitoringInstrumentation\":\"androidx.test.runner.MonitoringInstrumentation\",\"android.support.test.runner.permission.GrantPermissionCallable\":\"androidx.test.runner.permission.GrantPermissionCallable\",\"android.support.test.runner.permission.PermissionRequester\":\"androidx.test.runner.permission.PermissionRequester\",\"android.support.test.runner.permission.RequestPermissionCallable\":\"androidx.test.runner.permission.RequestPermissionCallable\",\"android.support.test.runner.permission.ShellCommand\":\"androidx.test.runner.permission.ShellCommand\",\"android.support.test.runner.permission.UiAutomationShellCommand\":\"androidx.test.runner.permission.UiAutomationShellCommand\",\"android.support.test.runner.screenshot.BasicScreenCaptureProcessor\":\"androidx.test.runner.screenshot.BasicScreenCaptureProcessor\",\"android.support.test.runner.screenshot.ScreenCapture\":\"androidx.test.runner.screenshot.ScreenCapture\",\"android.support.test.runner.screenshot.ScreenCaptureProcessor\":\"androidx.test.runner.screenshot.ScreenCaptureProcessor\",\"android.support.test.runner.screenshot.Screenshot\":\"androidx.test.runner.screenshot.Screenshot\",\"android.support.test.runner.screenshot.TakeScreenshotCallable\":\"androidx.test.runner.screenshot.TakeScreenshotCallable\",\"android.support.test.runner.screenshot.UiAutomationWrapper\":\"androidx.test.runner.screenshot.UiAutomationWrapper\",\"android.support.test.runner.UsageTrackerFacilitator\":\"androidx.test.runner.UsageTrackerFacilitator\",\"android.support.test.uiautomator.AccessibilityNodeInfoDumper\":\"androidx.test.uiautomator.AccessibilityNodeInfoDumper\",\"android.support.test.uiautomator.AccessibilityNodeInfoHelper\":\"androidx.test.uiautomator.AccessibilityNodeInfoHelper\",\"android.support.test.uiautomator.By\":\"androidx.test.uiautomator.By\",\"android.support.test.uiautomator.ByMatcher\":\"androidx.test.uiautomator.ByMatcher\",\"android.support.test.uiautomator.BySelector\":\"androidx.test.uiautomator.BySelector\",\"android.support.test.uiautomator.Condition\":\"androidx.test.uiautomator.Condition\",\"android.support.test.uiautomator.Configurator\":\"androidx.test.uiautomator.Configurator\",\"android.support.test.uiautomator.Direction\":\"androidx.test.uiautomator.Direction\",\"android.support.test.uiautomator.EventCondition\":\"androidx.test.uiautomator.EventCondition\",\"android.support.test.uiautomator.GestureController\":\"androidx.test.uiautomator.GestureController\",\"android.support.test.uiautomator.Gestures\":\"androidx.test.uiautomator.Gestures\",\"android.support.test.uiautomator.IAutomationSupport\":\"androidx.test.uiautomator.IAutomationSupport\",\"android.support.test.uiautomator.InstrumentationAutomationSupport\":\"androidx.test.uiautomator.InstrumentationAutomationSupport\",\"android.support.test.uiautomator.InteractionController\":\"androidx.test.uiautomator.InteractionController\",\"android.support.test.uiautomator.PointerGesture\":\"androidx.test.uiautomator.PointerGesture\",\"android.support.test.uiautomator.QueryController\":\"androidx.test.uiautomator.QueryController\",\"android.support.test.uiautomator.Searchable\":\"androidx.test.uiautomator.Searchable\",\"android.support.test.uiautomator.SearchCondition\":\"androidx.test.uiautomator.SearchCondition\",\"android.support.test.uiautomator.StaleObjectException\":\"androidx.test.uiautomator.StaleObjectException\",\"android.support.test.uiautomator.Tracer\":\"androidx.test.uiautomator.Tracer\",\"android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner\":\"androidx.test.uiautomator.UiAutomatorInstrumentationTestRunner\",\"android.support.test.uiautomator.UiAutomatorTestCase\":\"androidx.test.uiautomator.UiAutomatorTestCase\",\"android.support.test.uiautomator.UiCollection\":\"androidx.test.uiautomator.UiCollection\",\"android.support.test.uiautomator.UiDevice\":\"androidx.test.uiautomator.UiDevice\",\"android.support.test.uiautomator.UiObject\":\"androidx.test.uiautomator.UiObject\",\"android.support.test.uiautomator.UiObject2\":\"androidx.test.uiautomator.UiObject2\",\"android.support.test.uiautomator.UiObject2Condition\":\"androidx.test.uiautomator.UiObject2Condition\",\"android.support.test.uiautomator.UiObjectNotFoundException\":\"androidx.test.uiautomator.UiObjectNotFoundException\",\"android.support.test.uiautomator.UiScrollable\":\"androidx.test.uiautomator.UiScrollable\",\"android.support.test.uiautomator.UiSelector\":\"androidx.test.uiautomator.UiSelector\",\"android.support.test.uiautomator.UiWatcher\":\"androidx.test.uiautomator.UiWatcher\",\"android.support.test.uiautomator.Until\":\"androidx.test.uiautomator.Until\",\"android.support.test.uiautomator.WaitMixin\":\"androidx.test.uiautomator.WaitMixin\",\"android.support.text.emoji.bundled.BundledEmojiCompatConfig\":\"androidx.emoji.bundled.BundledEmojiCompatConfig\",\"android.support.text.emoji.EmojiCompat\":\"androidx.emoji.text.EmojiCompat\",\"android.support.text.emoji.EmojiMetadata\":\"androidx.emoji.text.EmojiMetadata\",\"android.support.text.emoji.EmojiProcessor\":\"androidx.emoji.text.EmojiProcessor\",\"android.support.text.emoji.EmojiSpan\":\"androidx.emoji.text.EmojiSpan\",\"android.support.text.emoji.FontRequestEmojiCompatConfig\":\"androidx.emoji.text.FontRequestEmojiCompatConfig\",\"android.support.text.emoji.MetadataListReader\":\"androidx.emoji.text.MetadataListReader\",\"android.support.text.emoji.MetadataRepo\":\"androidx.emoji.text.MetadataRepo\",\"android.support.text.emoji.R\":\"androidx.emoji.R\",\"android.support.text.emoji.TypefaceEmojiSpan\":\"androidx.emoji.text.TypefaceEmojiSpan\",\"android.support.text.emoji.widget.EditTextAttributeHelper\":\"androidx.emoji.widget.EditTextAttributeHelper\",\"android.support.text.emoji.widget.EmojiAppCompatButton\":\"androidx.emoji.widget.EmojiAppCompatButton\",\"android.support.text.emoji.widget.EmojiAppCompatEditText\":\"androidx.emoji.widget.EmojiAppCompatEditText\",\"android.support.text.emoji.widget.EmojiAppCompatTextView\":\"androidx.emoji.widget.EmojiAppCompatTextView\",\"android.support.text.emoji.widget.EmojiButton\":\"androidx.emoji.widget.EmojiButton\",\"android.support.text.emoji.widget.EmojiEditableFactory\":\"androidx.emoji.widget.EmojiEditableFactory\",\"android.support.text.emoji.widget.EmojiEditText\":\"androidx.emoji.widget.EmojiEditText\",\"android.support.text.emoji.widget.EmojiEditTextHelper\":\"androidx.emoji.widget.EmojiEditTextHelper\",\"android.support.text.emoji.widget.EmojiExtractEditText\":\"androidx.emoji.widget.EmojiExtractEditText\",\"android.support.text.emoji.widget.EmojiExtractTextLayout\":\"androidx.emoji.widget.EmojiExtractTextLayout\",\"android.support.text.emoji.widget.EmojiInputConnection\":\"androidx.emoji.widget.EmojiInputConnection\",\"android.support.text.emoji.widget.EmojiInputFilter\":\"androidx.emoji.widget.EmojiInputFilter\",\"android.support.text.emoji.widget.EmojiKeyListener\":\"androidx.emoji.widget.EmojiKeyListener\",\"android.support.text.emoji.widget.EmojiTextView\":\"androidx.emoji.widget.EmojiTextView\",\"android.support.text.emoji.widget.EmojiTextViewHelper\":\"androidx.emoji.widget.EmojiTextViewHelper\",\"android.support.text.emoji.widget.EmojiTextWatcher\":\"androidx.emoji.widget.EmojiTextWatcher\",\"android.support.text.emoji.widget.EmojiTransformationMethod\":\"androidx.emoji.widget.EmojiTransformationMethod\",\"android.support.text.emoji.widget.ExtractButtonCompat\":\"androidx.emoji.widget.ExtractButtonCompat\",\"android.support.text.emoji.widget.SpannableBuilder\":\"androidx.emoji.widget.SpannableBuilder\",\"android.support.transition.AnimatorUtils\":\"androidx.transition.AnimatorUtils\",\"android.support.transition.ArcMotion\":\"androidx.transition.ArcMotion\",\"android.support.transition.AutoTransition\":\"androidx.transition.AutoTransition\",\"android.support.transition.ChangeBounds\":\"androidx.transition.ChangeBounds\",\"android.support.transition.ChangeClipBounds\":\"androidx.transition.ChangeClipBounds\",\"android.support.transition.ChangeImageTransform\":\"androidx.transition.ChangeImageTransform\",\"android.support.transition.ChangeScroll\":\"androidx.transition.ChangeScroll\",\"android.support.transition.ChangeTransform\":\"androidx.transition.ChangeTransform\",\"android.support.transition.CircularPropagation\":\"androidx.transition.CircularPropagation\",\"android.support.transition.Explode\":\"androidx.transition.Explode\",\"android.support.transition.Fade\":\"androidx.transition.Fade\",\"android.support.transition.FloatArrayEvaluator\":\"androidx.transition.FloatArrayEvaluator\",\"android.support.transition.FragmentTransitionSupport\":\"androidx.transition.FragmentTransitionSupport\",\"android.support.transition.GhostViewApi14\":\"androidx.transition.GhostViewApi14\",\"android.support.transition.GhostViewApi21\":\"androidx.transition.GhostViewApi21\",\"android.support.transition.GhostViewImpl\":\"androidx.transition.GhostViewImpl\",\"android.support.transition.GhostViewUtils\":\"androidx.transition.GhostViewUtils\",\"android.support.transition.ImageViewUtils\":\"androidx.transition.ImageViewUtils\",\"android.support.transition.MatrixUtils\":\"androidx.transition.MatrixUtils\",\"android.support.transition.ObjectAnimatorUtils\":\"androidx.transition.ObjectAnimatorUtils\",\"android.support.transition.PathMotion\":\"androidx.transition.PathMotion\",\"android.support.transition.PathProperty\":\"androidx.transition.PathProperty\",\"android.support.transition.PatternPathMotion\":\"androidx.transition.PatternPathMotion\",\"android.support.transition.PropertyValuesHolderUtils\":\"androidx.transition.PropertyValuesHolderUtils\",\"android.support.transition.R\":\"androidx.transition.R\",\"android.support.transition.RectEvaluator\":\"androidx.transition.RectEvaluator\",\"android.support.transition.Scene\":\"androidx.transition.Scene\",\"android.support.transition.SidePropagation\":\"androidx.transition.SidePropagation\",\"android.support.transition.Slide\":\"androidx.transition.Slide\",\"android.support.transition.Styleable\":\"androidx.transition.Styleable\",\"android.support.transition.Transition\":\"androidx.transition.Transition\",\"android.support.transition.TransitionInflater\":\"androidx.transition.TransitionInflater\",\"android.support.transition.TransitionListenerAdapter\":\"androidx.transition.TransitionListenerAdapter\",\"android.support.transition.TransitionManager\":\"androidx.transition.TransitionManager\",\"android.support.transition.TransitionPropagation\":\"androidx.transition.TransitionPropagation\",\"android.support.transition.TransitionSet\":\"androidx.transition.TransitionSet\",\"android.support.transition.TransitionUtils\":\"androidx.transition.TransitionUtils\",\"android.support.transition.TransitionValues\":\"androidx.transition.TransitionValues\",\"android.support.transition.TransitionValuesMaps\":\"androidx.transition.TransitionValuesMaps\",\"android.support.transition.TranslationAnimationCreator\":\"androidx.transition.TranslationAnimationCreator\",\"android.support.transition.ViewGroupOverlayApi14\":\"androidx.transition.ViewGroupOverlayApi14\",\"android.support.transition.ViewGroupOverlayApi18\":\"androidx.transition.ViewGroupOverlayApi18\",\"android.support.transition.ViewGroupOverlayImpl\":\"androidx.transition.ViewGroupOverlayImpl\",\"android.support.transition.ViewGroupUtils\":\"androidx.transition.ViewGroupUtils\",\"android.support.transition.ViewGroupUtilsApi14\":\"androidx.transition.ViewGroupUtilsApi14\",\"android.support.transition.ViewGroupUtilsApi18\":\"androidx.transition.ViewGroupUtilsApi18\",\"android.support.transition.ViewOverlayApi14\":\"androidx.transition.ViewOverlayApi14\",\"android.support.transition.ViewOverlayApi18\":\"androidx.transition.ViewOverlayApi18\",\"android.support.transition.ViewOverlayImpl\":\"androidx.transition.ViewOverlayImpl\",\"android.support.transition.ViewUtils\":\"androidx.transition.ViewUtils\",\"android.support.transition.ViewUtilsApi19\":\"androidx.transition.ViewUtilsApi19\",\"android.support.transition.ViewUtilsApi21\":\"androidx.transition.ViewUtilsApi21\",\"android.support.transition.ViewUtilsApi22\":\"androidx.transition.ViewUtilsApi22\",\"android.support.transition.ViewUtilsBase\":\"androidx.transition.ViewUtilsBase\",\"android.support.transition.Visibility\":\"androidx.transition.Visibility\",\"android.support.transition.VisibilityPropagation\":\"androidx.transition.VisibilityPropagation\",\"android.support.transition.WindowIdApi14\":\"androidx.transition.WindowIdApi14\",\"android.support.transition.WindowIdApi18\":\"androidx.transition.WindowIdApi18\",\"android.support.transition.WindowIdImpl\":\"androidx.transition.WindowIdImpl\",\"android.support.v13.app.ActivityCompat\":\"androidx.legacy.app.ActivityCompat\",\"android.support.v13.app.FragmentCompat\":\"androidx.legacy.app.FragmentCompat\",\"android.support.v13.app.FragmentPagerAdapter\":\"androidx.legacy.app.FragmentPagerAdapter\",\"android.support.v13.app.FragmentStatePagerAdapter\":\"androidx.legacy.app.FragmentStatePagerAdapter\",\"android.support.v13.app.FragmentTabHost\":\"androidx.legacy.app.FragmentTabHost\",\"android.support.v13.view.DragAndDropPermissionsCompat\":\"androidx.core.view.DragAndDropPermissionsCompat\",\"android.support.v13.view.DragStartHelper\":\"androidx.core.view.DragStartHelper\",\"android.support.v13.view.inputmethod.EditorInfoCompat\":\"androidx.core.view.inputmethod.EditorInfoCompat\",\"android.support.v13.view.inputmethod.InputConnectionCompat\":\"androidx.core.view.inputmethod.InputConnectionCompat\",\"android.support.v13.view.inputmethod.InputContentInfoCompat\":\"androidx.core.view.inputmethod.InputContentInfoCompat\",\"android.support.v13.view.ViewCompat\":\"androidx.legacy.view.ViewCompat\",\"android.support.v14.preference.EditTextPreferenceDialogFragment\":\"androidx.preference.EditTextPreferenceDialogFragment\",\"android.support.v14.preference.ListPreferenceDialogFragment\":\"androidx.preference.ListPreferenceDialogFragment\",\"android.support.v14.preference.MultiSelectListPreference\":\"androidx.preference.MultiSelectListPreference\",\"android.support.v14.preference.MultiSelectListPreferenceDialogFragment\":\"androidx.preference.MultiSelectListPreferenceDialogFragment\",\"android.support.v14.preference.PreferenceDialogFragment\":\"androidx.preference.PreferenceDialogFragment\",\"android.support.v14.preference.PreferenceFragment\":\"androidx.preference.PreferenceFragment\",\"android.support.v14.preference.SwitchPreference\":\"androidx.preference.SwitchPreference\",\"android.support.v17.internal.widget.OutlineOnlyWithChildrenFrameLayout\":\"androidx.leanback.preference.internal.OutlineOnlyWithChildrenFrameLayout\",\"android.support.v17.leanback.animation.LogAccelerateInterpolator\":\"androidx.leanback.animation.LogAccelerateInterpolator\",\"android.support.v17.leanback.animation.LogDecelerateInterpolator\":\"androidx.leanback.animation.LogDecelerateInterpolator\",\"android.support.v17.leanback.app.BackgroundFragment\":\"androidx.leanback.app.BackgroundFragment\",\"android.support.v17.leanback.app.BackgroundManager\":\"androidx.leanback.app.BackgroundManager\",\"android.support.v17.leanback.app.BaseFragment\":\"androidx.leanback.app.BaseFragment\",\"android.support.v17.leanback.app.BaseRowFragment\":\"androidx.leanback.app.BaseRowFragment\",\"android.support.v17.leanback.app.BaseRowSupportFragment\":\"androidx.leanback.app.BaseRowSupportFragment\",\"android.support.v17.leanback.app.BaseSupportFragment\":\"androidx.leanback.app.BaseSupportFragment\",\"android.support.v17.leanback.app.BrandedFragment\":\"androidx.leanback.app.BrandedFragment\",\"android.support.v17.leanback.app.BrandedSupportFragment\":\"androidx.leanback.app.BrandedSupportFragment\",\"android.support.v17.leanback.app.BrowseFragment\":\"androidx.leanback.app.BrowseFragment\",\"android.support.v17.leanback.app.BrowseSupportFragment\":\"androidx.leanback.app.BrowseSupportFragment\",\"android.support.v17.leanback.app.DetailsBackgroundVideoHelper\":\"androidx.leanback.app.DetailsBackgroundVideoHelper\",\"android.support.v17.leanback.app.DetailsFragment\":\"androidx.leanback.app.DetailsFragment\",\"android.support.v17.leanback.app.DetailsFragmentBackgroundController\":\"androidx.leanback.app.DetailsFragmentBackgroundController\",\"android.support.v17.leanback.app.DetailsSupportFragment\":\"androidx.leanback.app.DetailsSupportFragment\",\"android.support.v17.leanback.app.DetailsSupportFragmentBackgroundController\":\"androidx.leanback.app.DetailsSupportFragmentBackgroundController\",\"android.support.v17.leanback.app.ErrorFragment\":\"androidx.leanback.app.ErrorFragment\",\"android.support.v17.leanback.app.ErrorSupportFragment\":\"androidx.leanback.app.ErrorSupportFragment\",\"android.support.v17.leanback.app.FragmentUtil\":\"androidx.leanback.app.FragmentUtil\",\"android.support.v17.leanback.app.GuidedStepFragment\":\"androidx.leanback.app.GuidedStepFragment\",\"android.support.v17.leanback.app.GuidedStepRootLayout\":\"androidx.leanback.app.GuidedStepRootLayout\",\"android.support.v17.leanback.app.GuidedStepSupportFragment\":\"androidx.leanback.app.GuidedStepSupportFragment\",\"android.support.v17.leanback.app.HeadersFragment\":\"androidx.leanback.app.HeadersFragment\",\"android.support.v17.leanback.app.HeadersSupportFragment\":\"androidx.leanback.app.HeadersSupportFragment\",\"android.support.v17.leanback.app.ListRowDataAdapter\":\"androidx.leanback.app.ListRowDataAdapter\",\"android.support.v17.leanback.app.OnboardingFragment\":\"androidx.leanback.app.OnboardingFragment\",\"android.support.v17.leanback.app.OnboardingSupportFragment\":\"androidx.leanback.app.OnboardingSupportFragment\",\"android.support.v17.leanback.app.PermissionHelper\":\"androidx.leanback.app.PermissionHelper\",\"android.support.v17.leanback.app.PlaybackFragment\":\"androidx.leanback.app.PlaybackFragment\",\"android.support.v17.leanback.app.PlaybackFragmentGlueHost\":\"androidx.leanback.app.PlaybackFragmentGlueHost\",\"android.support.v17.leanback.app.PlaybackSupportFragment\":\"androidx.leanback.app.PlaybackSupportFragment\",\"android.support.v17.leanback.app.PlaybackSupportFragmentGlueHost\":\"androidx.leanback.app.PlaybackSupportFragmentGlueHost\",\"android.support.v17.leanback.app.ProgressBarManager\":\"androidx.leanback.app.ProgressBarManager\",\"android.support.v17.leanback.app.RowsFragment\":\"androidx.leanback.app.RowsFragment\",\"android.support.v17.leanback.app.RowsSupportFragment\":\"androidx.leanback.app.RowsSupportFragment\",\"android.support.v17.leanback.app.SearchFragment\":\"androidx.leanback.app.SearchFragment\",\"android.support.v17.leanback.app.SearchSupportFragment\":\"androidx.leanback.app.SearchSupportFragment\",\"android.support.v17.leanback.app.VerticalGridFragment\":\"androidx.leanback.app.VerticalGridFragment\",\"android.support.v17.leanback.app.VerticalGridSupportFragment\":\"androidx.leanback.app.VerticalGridSupportFragment\",\"android.support.v17.leanback.app.VideoFragment\":\"androidx.leanback.app.VideoFragment\",\"android.support.v17.leanback.app.VideoFragmentGlueHost\":\"androidx.leanback.app.VideoFragmentGlueHost\",\"android.support.v17.leanback.app.VideoSupportFragment\":\"androidx.leanback.app.VideoSupportFragment\",\"android.support.v17.leanback.app.VideoSupportFragmentGlueHost\":\"androidx.leanback.app.VideoSupportFragmentGlueHost\",\"android.support.v17.leanback.database.CursorMapper\":\"androidx.leanback.database.CursorMapper\",\"android.support.v17.leanback.graphics.BoundsRule\":\"androidx.leanback.graphics.BoundsRule\",\"android.support.v17.leanback.graphics.ColorFilterCache\":\"androidx.leanback.graphics.ColorFilterCache\",\"android.support.v17.leanback.graphics.ColorFilterDimmer\":\"androidx.leanback.graphics.ColorFilterDimmer\",\"android.support.v17.leanback.graphics.ColorOverlayDimmer\":\"androidx.leanback.graphics.ColorOverlayDimmer\",\"android.support.v17.leanback.graphics.CompositeDrawable\":\"androidx.leanback.graphics.CompositeDrawable\",\"android.support.v17.leanback.graphics.FitWidthBitmapDrawable\":\"androidx.leanback.graphics.FitWidthBitmapDrawable\",\"android.support.v17.leanback.media.MediaControllerAdapter\":\"androidx.leanback.media.MediaControllerAdapter\",\"android.support.v17.leanback.media.MediaControllerGlue\":\"androidx.leanback.media.MediaControllerGlue\",\"android.support.v17.leanback.media.MediaPlayerAdapter\":\"androidx.leanback.media.MediaPlayerAdapter\",\"android.support.v17.leanback.media.MediaPlayerGlue\":\"androidx.leanback.media.MediaPlayerGlue\",\"android.support.v17.leanback.media.PlaybackBannerControlGlue\":\"androidx.leanback.media.PlaybackBannerControlGlue\",\"android.support.v17.leanback.media.PlaybackBaseControlGlue\":\"androidx.leanback.media.PlaybackBaseControlGlue\",\"android.support.v17.leanback.media.PlaybackControlGlue\":\"androidx.leanback.media.PlaybackControlGlue\",\"android.support.v17.leanback.media.PlaybackGlue\":\"androidx.leanback.media.PlaybackGlue\",\"android.support.v17.leanback.media.PlaybackGlueHost\":\"androidx.leanback.media.PlaybackGlueHost\",\"android.support.v17.leanback.media.PlaybackTransportControlGlue\":\"androidx.leanback.media.PlaybackTransportControlGlue\",\"android.support.v17.leanback.media.PlayerAdapter\":\"androidx.leanback.media.PlayerAdapter\",\"android.support.v17.leanback.media.SurfaceHolderGlueHost\":\"androidx.leanback.media.SurfaceHolderGlueHost\",\"android.support.v17.leanback.R\":\"androidx.leanback.R\",\"android.support.v17.leanback.system.Settings\":\"androidx.leanback.system.Settings\",\"android.support.v17.leanback.transition.CustomChangeBounds\":\"androidx.leanback.transition.CustomChangeBounds\",\"android.support.v17.leanback.transition.FadeAndShortSlide\":\"androidx.leanback.transition.FadeAndShortSlide\",\"android.support.v17.leanback.transition.LeanbackTransitionHelper\":\"androidx.leanback.transition.LeanbackTransitionHelper\",\"android.support.v17.leanback.transition.ParallaxTransition\":\"androidx.leanback.transition.ParallaxTransition\",\"android.support.v17.leanback.transition.Scale\":\"androidx.leanback.transition.Scale\",\"android.support.v17.leanback.transition.SlideKitkat\":\"androidx.leanback.transition.SlideKitkat\",\"android.support.v17.leanback.transition.SlideNoPropagation\":\"androidx.leanback.transition.SlideNoPropagation\",\"android.support.v17.leanback.transition.TransitionEpicenterCallback\":\"androidx.leanback.transition.TransitionEpicenterCallback\",\"android.support.v17.leanback.transition.TransitionHelper\":\"androidx.leanback.transition.TransitionHelper\",\"android.support.v17.leanback.transition.TransitionListener\":\"androidx.leanback.transition.TransitionListener\",\"android.support.v17.leanback.transition.TranslationAnimationCreator\":\"androidx.leanback.transition.TranslationAnimationCreator\",\"android.support.v17.leanback.util.MathUtil\":\"androidx.leanback.util.MathUtil\",\"android.support.v17.leanback.util.StateMachine\":\"androidx.leanback.util.StateMachine\",\"android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter\":\"androidx.leanback.widget.AbstractDetailsDescriptionPresenter\",\"android.support.v17.leanback.widget.AbstractMediaItemPresenter\":\"androidx.leanback.widget.AbstractMediaItemPresenter\",\"android.support.v17.leanback.widget.AbstractMediaListHeaderPresenter\":\"androidx.leanback.widget.AbstractMediaListHeaderPresenter\",\"android.support.v17.leanback.widget.Action\":\"androidx.leanback.widget.Action\",\"android.support.v17.leanback.widget.ActionPresenterSelector\":\"androidx.leanback.widget.ActionPresenterSelector\",\"android.support.v17.leanback.widget.ArrayObjectAdapter\":\"androidx.leanback.widget.ArrayObjectAdapter\",\"android.support.v17.leanback.widget.BackgroundHelper\":\"androidx.leanback.widget.BackgroundHelper\",\"android.support.v17.leanback.widget.BaseCardView\":\"androidx.leanback.widget.BaseCardView\",\"android.support.v17.leanback.widget.BaseGridView\":\"androidx.leanback.widget.BaseGridView\",\"android.support.v17.leanback.widget.BaseOnItemViewClickedListener\":\"androidx.leanback.widget.BaseOnItemViewClickedListener\",\"android.support.v17.leanback.widget.BaseOnItemViewSelectedListener\":\"androidx.leanback.widget.BaseOnItemViewSelectedListener\",\"android.support.v17.leanback.widget.BrowseFrameLayout\":\"androidx.leanback.widget.BrowseFrameLayout\",\"android.support.v17.leanback.widget.BrowseRowsFrameLayout\":\"androidx.leanback.widget.BrowseRowsFrameLayout\",\"android.support.v17.leanback.widget.CheckableImageView\":\"androidx.leanback.widget.CheckableImageView\",\"android.support.v17.leanback.widget.ClassPresenterSelector\":\"androidx.leanback.widget.ClassPresenterSelector\",\"android.support.v17.leanback.widget.ControlBar\":\"androidx.leanback.widget.ControlBar\",\"android.support.v17.leanback.widget.ControlBarPresenter\":\"androidx.leanback.widget.ControlBarPresenter\",\"android.support.v17.leanback.widget.ControlButtonPresenterSelector\":\"androidx.leanback.widget.ControlButtonPresenterSelector\",\"android.support.v17.leanback.widget.CursorObjectAdapter\":\"androidx.leanback.widget.CursorObjectAdapter\",\"android.support.v17.leanback.widget.DetailsOverviewLogoPresenter\":\"androidx.leanback.widget.DetailsOverviewLogoPresenter\",\"android.support.v17.leanback.widget.DetailsOverviewRow\":\"androidx.leanback.widget.DetailsOverviewRow\",\"android.support.v17.leanback.widget.DetailsOverviewRowPresenter\":\"androidx.leanback.widget.DetailsOverviewRowPresenter\",\"android.support.v17.leanback.widget.DetailsOverviewSharedElementHelper\":\"androidx.leanback.widget.DetailsOverviewSharedElementHelper\",\"android.support.v17.leanback.widget.DetailsParallax\":\"androidx.leanback.widget.DetailsParallax\",\"android.support.v17.leanback.widget.DetailsParallaxDrawable\":\"androidx.leanback.widget.DetailsParallaxDrawable\",\"android.support.v17.leanback.widget.DiffCallback\":\"androidx.leanback.widget.DiffCallback\",\"android.support.v17.leanback.widget.DividerPresenter\":\"androidx.leanback.widget.DividerPresenter\",\"android.support.v17.leanback.widget.DividerRow\":\"androidx.leanback.widget.DividerRow\",\"android.support.v17.leanback.widget.FacetProvider\":\"androidx.leanback.widget.FacetProvider\",\"android.support.v17.leanback.widget.FacetProviderAdapter\":\"androidx.leanback.widget.FacetProviderAdapter\",\"android.support.v17.leanback.widget.FocusHighlight\":\"androidx.leanback.widget.FocusHighlight\",\"android.support.v17.leanback.widget.FocusHighlightHandler\":\"androidx.leanback.widget.FocusHighlightHandler\",\"android.support.v17.leanback.widget.FocusHighlightHelper\":\"androidx.leanback.widget.FocusHighlightHelper\",\"android.support.v17.leanback.widget.ForegroundHelper\":\"androidx.leanback.widget.ForegroundHelper\",\"android.support.v17.leanback.widget.FragmentAnimationProvider\":\"androidx.leanback.widget.FragmentAnimationProvider\",\"android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter\":\"androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter\",\"android.support.v17.leanback.widget.FullWidthDetailsOverviewSharedElementHelper\":\"androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper\",\"android.support.v17.leanback.widget.Grid\":\"androidx.leanback.widget.Grid\",\"android.support.v17.leanback.widget.GridLayoutManager\":\"androidx.leanback.widget.GridLayoutManager\",\"android.support.v17.leanback.widget.GuidanceStylingRelativeLayout\":\"androidx.leanback.widget.GuidanceStylingRelativeLayout\",\"android.support.v17.leanback.widget.GuidanceStylist\":\"androidx.leanback.widget.GuidanceStylist\",\"android.support.v17.leanback.widget.GuidedAction\":\"androidx.leanback.widget.GuidedAction\",\"android.support.v17.leanback.widget.GuidedActionAdapter\":\"androidx.leanback.widget.GuidedActionAdapter\",\"android.support.v17.leanback.widget.GuidedActionAdapterGroup\":\"androidx.leanback.widget.GuidedActionAdapterGroup\",\"android.support.v17.leanback.widget.GuidedActionAutofillSupport\":\"androidx.leanback.widget.GuidedActionAutofillSupport\",\"android.support.v17.leanback.widget.GuidedActionDiffCallback\":\"androidx.leanback.widget.GuidedActionDiffCallback\",\"android.support.v17.leanback.widget.GuidedActionEditText\":\"androidx.leanback.widget.GuidedActionEditText\",\"android.support.v17.leanback.widget.GuidedActionItemContainer\":\"androidx.leanback.widget.GuidedActionItemContainer\",\"android.support.v17.leanback.widget.GuidedActionsRelativeLayout\":\"androidx.leanback.widget.GuidedActionsRelativeLayout\",\"android.support.v17.leanback.widget.GuidedActionsStylist\":\"androidx.leanback.widget.GuidedActionsStylist\",\"android.support.v17.leanback.widget.GuidedDatePickerAction\":\"androidx.leanback.widget.GuidedDatePickerAction\",\"android.support.v17.leanback.widget.HeaderItem\":\"androidx.leanback.widget.HeaderItem\",\"android.support.v17.leanback.widget.HorizontalGridView\":\"androidx.leanback.widget.HorizontalGridView\",\"android.support.v17.leanback.widget.HorizontalHoverCardSwitcher\":\"androidx.leanback.widget.HorizontalHoverCardSwitcher\",\"android.support.v17.leanback.widget.ImageCardView\":\"androidx.leanback.widget.ImageCardView\",\"android.support.v17.leanback.widget.ImeKeyMonitor\":\"androidx.leanback.widget.ImeKeyMonitor\",\"android.support.v17.leanback.widget.InvisibleRowPresenter\":\"androidx.leanback.widget.InvisibleRowPresenter\",\"android.support.v17.leanback.widget.ItemAlignment\":\"androidx.leanback.widget.ItemAlignment\",\"android.support.v17.leanback.widget.ItemAlignmentFacet\":\"androidx.leanback.widget.ItemAlignmentFacet\",\"android.support.v17.leanback.widget.ItemAlignmentFacetHelper\":\"androidx.leanback.widget.ItemAlignmentFacetHelper\",\"android.support.v17.leanback.widget.ItemBridgeAdapter\":\"androidx.leanback.widget.ItemBridgeAdapter\",\"android.support.v17.leanback.widget.ItemBridgeAdapterShadowOverlayWrapper\":\"androidx.leanback.widget.ItemBridgeAdapterShadowOverlayWrapper\",\"android.support.v17.leanback.widget.ListRow\":\"androidx.leanback.widget.ListRow\",\"android.support.v17.leanback.widget.ListRowHoverCardView\":\"androidx.leanback.widget.ListRowHoverCardView\",\"android.support.v17.leanback.widget.ListRowPresenter\":\"androidx.leanback.widget.ListRowPresenter\",\"android.support.v17.leanback.widget.ListRowView\":\"androidx.leanback.widget.ListRowView\",\"android.support.v17.leanback.widget.MediaItemActionPresenter\":\"androidx.leanback.widget.MediaItemActionPresenter\",\"android.support.v17.leanback.widget.MediaNowPlayingView\":\"androidx.leanback.widget.MediaNowPlayingView\",\"android.support.v17.leanback.widget.MediaRowFocusView\":\"androidx.leanback.widget.MediaRowFocusView\",\"android.support.v17.leanback.widget.MultiActionsProvider\":\"androidx.leanback.widget.MultiActionsProvider\",\"android.support.v17.leanback.widget.NonOverlappingFrameLayout\":\"androidx.leanback.widget.NonOverlappingFrameLayout\",\"android.support.v17.leanback.widget.NonOverlappingLinearLayout\":\"androidx.leanback.widget.NonOverlappingLinearLayout\",\"android.support.v17.leanback.widget.NonOverlappingLinearLayoutWithForeground\":\"androidx.leanback.widget.NonOverlappingLinearLayoutWithForeground\",\"android.support.v17.leanback.widget.NonOverlappingRelativeLayout\":\"androidx.leanback.widget.NonOverlappingRelativeLayout\",\"android.support.v17.leanback.widget.NonOverlappingView\":\"androidx.leanback.widget.NonOverlappingView\",\"android.support.v17.leanback.widget.ObjectAdapter\":\"androidx.leanback.widget.ObjectAdapter\",\"android.support.v17.leanback.widget.OnActionClickedListener\":\"androidx.leanback.widget.OnActionClickedListener\",\"android.support.v17.leanback.widget.OnChildLaidOutListener\":\"androidx.leanback.widget.OnChildLaidOutListener\",\"android.support.v17.leanback.widget.OnChildSelectedListener\":\"androidx.leanback.widget.OnChildSelectedListener\",\"android.support.v17.leanback.widget.OnChildViewHolderSelectedListener\":\"androidx.leanback.widget.OnChildViewHolderSelectedListener\",\"android.support.v17.leanback.widget.OnItemViewClickedListener\":\"androidx.leanback.widget.OnItemViewClickedListener\",\"android.support.v17.leanback.widget.OnItemViewSelectedListener\":\"androidx.leanback.widget.OnItemViewSelectedListener\",\"android.support.v17.leanback.widget.PageRow\":\"androidx.leanback.widget.PageRow\",\"android.support.v17.leanback.widget.PagingIndicator\":\"androidx.leanback.widget.PagingIndicator\",\"android.support.v17.leanback.widget.Parallax\":\"androidx.leanback.widget.Parallax\",\"android.support.v17.leanback.widget.ParallaxEffect\":\"androidx.leanback.widget.ParallaxEffect\",\"android.support.v17.leanback.widget.ParallaxTarget\":\"androidx.leanback.widget.ParallaxTarget\",\"android.support.v17.leanback.widget.PersistentFocusWrapper\":\"androidx.leanback.widget.PersistentFocusWrapper\",\"android.support.v17.leanback.widget.picker.DatePicker\":\"androidx.leanback.widget.picker.DatePicker\",\"android.support.v17.leanback.widget.picker.Picker\":\"androidx.leanback.widget.picker.Picker\",\"android.support.v17.leanback.widget.picker.PickerColumn\":\"androidx.leanback.widget.picker.PickerColumn\",\"android.support.v17.leanback.widget.picker.PickerUtility\":\"androidx.leanback.widget.picker.PickerUtility\",\"android.support.v17.leanback.widget.picker.TimePicker\":\"androidx.leanback.widget.picker.TimePicker\",\"android.support.v17.leanback.widget.PlaybackControlsPresenter\":\"androidx.leanback.widget.PlaybackControlsPresenter\",\"android.support.v17.leanback.widget.PlaybackControlsRow\":\"androidx.leanback.widget.PlaybackControlsRow\",\"android.support.v17.leanback.widget.PlaybackControlsRowPresenter\":\"androidx.leanback.widget.PlaybackControlsRowPresenter\",\"android.support.v17.leanback.widget.PlaybackControlsRowView\":\"androidx.leanback.widget.PlaybackControlsRowView\",\"android.support.v17.leanback.widget.PlaybackRowPresenter\":\"androidx.leanback.widget.PlaybackRowPresenter\",\"android.support.v17.leanback.widget.PlaybackSeekDataProvider\":\"androidx.leanback.widget.PlaybackSeekDataProvider\",\"android.support.v17.leanback.widget.PlaybackSeekUi\":\"androidx.leanback.widget.PlaybackSeekUi\",\"android.support.v17.leanback.widget.PlaybackTransportRowPresenter\":\"androidx.leanback.widget.PlaybackTransportRowPresenter\",\"android.support.v17.leanback.widget.PlaybackTransportRowView\":\"androidx.leanback.widget.PlaybackTransportRowView\",\"android.support.v17.leanback.widget.Presenter\":\"androidx.leanback.widget.Presenter\",\"android.support.v17.leanback.widget.PresenterSelector\":\"androidx.leanback.widget.PresenterSelector\",\"android.support.v17.leanback.widget.PresenterSwitcher\":\"androidx.leanback.widget.PresenterSwitcher\",\"android.support.v17.leanback.widget.RecyclerViewParallax\":\"androidx.leanback.widget.RecyclerViewParallax\",\"android.support.v17.leanback.widget.ResizingTextView\":\"androidx.leanback.widget.ResizingTextView\",\"android.support.v17.leanback.widget.RoundedRectHelper\":\"androidx.leanback.widget.RoundedRectHelper\",\"android.support.v17.leanback.widget.RoundedRectHelperApi21\":\"androidx.leanback.widget.RoundedRectHelperApi21\",\"android.support.v17.leanback.widget.Row\":\"androidx.leanback.widget.Row\",\"android.support.v17.leanback.widget.RowContainerView\":\"androidx.leanback.widget.RowContainerView\",\"android.support.v17.leanback.widget.RowHeaderPresenter\":\"androidx.leanback.widget.RowHeaderPresenter\",\"android.support.v17.leanback.widget.RowHeaderView\":\"androidx.leanback.widget.RowHeaderView\",\"android.support.v17.leanback.widget.RowPresenter\":\"androidx.leanback.widget.RowPresenter\",\"android.support.v17.leanback.widget.ScaleFrameLayout\":\"androidx.leanback.widget.ScaleFrameLayout\",\"android.support.v17.leanback.widget.SearchBar\":\"androidx.leanback.widget.SearchBar\",\"android.support.v17.leanback.widget.SearchEditText\":\"androidx.leanback.widget.SearchEditText\",\"android.support.v17.leanback.widget.SearchOrbView\":\"androidx.leanback.widget.SearchOrbView\",\"android.support.v17.leanback.widget.SectionRow\":\"androidx.leanback.widget.SectionRow\",\"android.support.v17.leanback.widget.SeekBar\":\"androidx.leanback.widget.SeekBar\",\"android.support.v17.leanback.widget.ShadowHelper\":\"androidx.leanback.widget.ShadowHelper\",\"android.support.v17.leanback.widget.ShadowHelperApi21\":\"androidx.leanback.widget.ShadowHelperApi21\",\"android.support.v17.leanback.widget.ShadowOverlayContainer\":\"androidx.leanback.widget.ShadowOverlayContainer\",\"android.support.v17.leanback.widget.ShadowOverlayHelper\":\"androidx.leanback.widget.ShadowOverlayHelper\",\"android.support.v17.leanback.widget.SinglePresenterSelector\":\"androidx.leanback.widget.SinglePresenterSelector\",\"android.support.v17.leanback.widget.SingleRow\":\"androidx.leanback.widget.SingleRow\",\"android.support.v17.leanback.widget.SparseArrayObjectAdapter\":\"androidx.leanback.widget.SparseArrayObjectAdapter\",\"android.support.v17.leanback.widget.SpeechOrbView\":\"androidx.leanback.widget.SpeechOrbView\",\"android.support.v17.leanback.widget.SpeechRecognitionCallback\":\"androidx.leanback.widget.SpeechRecognitionCallback\",\"android.support.v17.leanback.widget.StaggeredGrid\":\"androidx.leanback.widget.StaggeredGrid\",\"android.support.v17.leanback.widget.StaggeredGridDefault\":\"androidx.leanback.widget.StaggeredGridDefault\",\"android.support.v17.leanback.widget.StaticShadowHelper\":\"androidx.leanback.widget.StaticShadowHelper\",\"android.support.v17.leanback.widget.StreamingTextView\":\"androidx.leanback.widget.StreamingTextView\",\"android.support.v17.leanback.widget.ThumbsBar\":\"androidx.leanback.widget.ThumbsBar\",\"android.support.v17.leanback.widget.TitleHelper\":\"androidx.leanback.widget.TitleHelper\",\"android.support.v17.leanback.widget.TitleView\":\"androidx.leanback.widget.TitleView\",\"android.support.v17.leanback.widget.TitleViewAdapter\":\"androidx.leanback.widget.TitleViewAdapter\",\"android.support.v17.leanback.widget.Util\":\"androidx.leanback.widget.Util\",\"android.support.v17.leanback.widget.VerticalGridPresenter\":\"androidx.leanback.widget.VerticalGridPresenter\",\"android.support.v17.leanback.widget.VerticalGridView\":\"androidx.leanback.widget.VerticalGridView\",\"android.support.v17.leanback.widget.VideoSurfaceView\":\"androidx.leanback.widget.VideoSurfaceView\",\"android.support.v17.leanback.widget.ViewHolderTask\":\"androidx.leanback.widget.ViewHolderTask\",\"android.support.v17.leanback.widget.ViewsStateBundle\":\"androidx.leanback.widget.ViewsStateBundle\",\"android.support.v17.leanback.widget.Visibility\":\"androidx.leanback.widget.Visibility\",\"android.support.v17.leanback.widget.WindowAlignment\":\"androidx.leanback.widget.WindowAlignment\",\"android.support.v17.preference.BaseLeanbackPreferenceFragment\":\"androidx.leanback.preference.BaseLeanbackPreferenceFragment\",\"android.support.v17.preference.LeanbackListPreferenceDialogFragment\":\"androidx.leanback.preference.LeanbackListPreferenceDialogFragment\",\"android.support.v17.preference.LeanbackPreferenceDialogFragment\":\"androidx.leanback.preference.LeanbackPreferenceDialogFragment\",\"android.support.v17.preference.LeanbackPreferenceFragment\":\"androidx.leanback.preference.LeanbackPreferenceFragment\",\"android.support.v17.preference.LeanbackPreferenceFragmentTransitionHelperApi21\":\"androidx.leanback.preference.LeanbackPreferenceFragmentTransitionHelperApi21\",\"android.support.v17.preference.LeanbackSettingsFragment\":\"androidx.leanback.preference.LeanbackSettingsFragment\",\"android.support.v17.preference.LeanbackSettingsRootView\":\"androidx.leanback.preference.LeanbackSettingsRootView\",\"android.support.v17.preference.R\":\"androidx.leanback.preference.R\",\"android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat\":\"androidx.core.accessibilityservice.AccessibilityServiceInfoCompat\",\"android.support.v4.app.ActionBarDrawerToggle\":\"androidx.legacy.app.ActionBarDrawerToggle\",\"android.support.v4.app.ActivityCompat\":\"androidx.core.app.ActivityCompat\",\"android.support.v4.app.ActivityManagerCompat\":\"androidx.core.app.ActivityManagerCompat\",\"android.support.v4.app.ActivityOptionsCompat\":\"androidx.core.app.ActivityOptionsCompat\",\"android.support.v4.app.AlarmManagerCompat\":\"androidx.core.app.AlarmManagerCompat\",\"android.support.v4.app.AppComponentFactory\":\"androidx.core.app.AppComponentFactory\",\"android.support.v4.app.AppLaunchChecker\":\"androidx.core.app.AppLaunchChecker\",\"android.support.v4.app.AppOpsManagerCompat\":\"androidx.core.app.AppOpsManagerCompat\",\"android.support.v4.app.BackStackRecord\":\"androidx.fragment.app.BackStackRecord\",\"android.support.v4.app.BackStackState\":\"androidx.fragment.app.BackStackState\",\"android.support.v4.app.BundleCompat\":\"androidx.core.app.BundleCompat\",\"android.support.v4.app.CoreComponentFactory\":\"androidx.core.app.CoreComponentFactory\",\"android.support.v4.app.DialogFragment\":\"androidx.fragment.app.DialogFragment\",\"android.support.v4.app.Fragment\":\"androidx.fragment.app.Fragment\",\"android.support.v4.app.FragmentActivity\":\"androidx.fragment.app.FragmentActivity\",\"android.support.v4.app.FragmentContainer\":\"androidx.fragment.app.FragmentContainer\",\"android.support.v4.app.FragmentController\":\"androidx.fragment.app.FragmentController\",\"android.support.v4.app.FragmentHostCallback\":\"androidx.fragment.app.FragmentHostCallback\",\"android.support.v4.app.FragmentManager\":\"androidx.fragment.app.FragmentManager\",\"android.support.v4.app.FragmentManagerImpl\":\"androidx.fragment.app.FragmentManagerImpl\",\"android.support.v4.app.FragmentManagerNonConfig\":\"androidx.fragment.app.FragmentManagerNonConfig\",\"android.support.v4.app.FragmentManagerState\":\"androidx.fragment.app.FragmentManagerState\",\"android.support.v4.app.FragmentPagerAdapter\":\"androidx.fragment.app.FragmentPagerAdapter\",\"android.support.v4.app.FragmentState\":\"androidx.fragment.app.FragmentState\",\"android.support.v4.app.FragmentStatePagerAdapter\":\"androidx.fragment.app.FragmentStatePagerAdapter\",\"android.support.v4.app.FragmentTabHost\":\"androidx.fragment.app.FragmentTabHost\",\"android.support.v4.app.FragmentTransaction\":\"androidx.fragment.app.FragmentTransaction\",\"android.support.v4.app.FragmentTransition\":\"androidx.fragment.app.FragmentTransition\",\"android.support.v4.app.FragmentTransitionCompat21\":\"androidx.fragment.app.FragmentTransitionCompat21\",\"android.support.v4.app.FragmentTransitionImpl\":\"androidx.fragment.app.FragmentTransitionImpl\",\"android.support.v4.app.FrameMetricsAggregator\":\"androidx.core.app.FrameMetricsAggregator\",\"android.support.v4.app.INotificationSideChannel\":\"androidx.core.app.INotificationSideChannel\",\"android.support.v4.app.JobIntentService\":\"androidx.core.app.JobIntentService\",\"android.support.v4.app.ListFragment\":\"androidx.fragment.app.ListFragment\",\"android.support.v4.app.LoaderManager\":\"androidx.loader.app.LoaderManager\",\"android.support.v4.app.LoaderManagerImpl\":\"androidx.loader.app.LoaderManagerImpl\",\"android.support.v4.app.NavUtils\":\"androidx.core.app.NavUtils\",\"android.support.v4.app.NotificationBuilderWithBuilderAccessor\":\"androidx.core.app.NotificationBuilderWithBuilderAccessor\",\"android.support.v4.app.NotificationCompat\":\"androidx.core.app.NotificationCompat\",\"android.support.v4.app.NotificationCompatBuilder\":\"androidx.core.app.NotificationCompatBuilder\",\"android.support.v4.app.NotificationCompatExtras\":\"androidx.core.app.NotificationCompatExtras\",\"android.support.v4.app.NotificationCompatJellybean\":\"androidx.core.app.NotificationCompatJellybean\",\"android.support.v4.app.NotificationCompatSideChannelService\":\"androidx.core.app.NotificationCompatSideChannelService\",\"android.support.v4.app.NotificationManagerCompat\":\"androidx.core.app.NotificationManagerCompat\",\"android.support.v4.app.OneShotPreDrawListener\":\"androidx.fragment.app.OneShotPreDrawListener\",\"android.support.v4.app.Person\":\"androidx.core.app.Person\",\"android.support.v4.app.RemoteInput\":\"androidx.core.app.RemoteInput\",\"android.support.v4.app.ServiceCompat\":\"androidx.core.app.ServiceCompat\",\"android.support.v4.app.ShareCompat\":\"androidx.core.app.ShareCompat\",\"android.support.v4.app.SharedElementCallback\":\"androidx.core.app.SharedElementCallback\",\"android.support.v4.app.SuperNotCalledException\":\"androidx.fragment.app.SuperNotCalledException\",\"android.support.v4.app.SupportActivity\":\"androidx.core.app.ComponentActivity\",\"android.support.v4.app.TaskStackBuilder\":\"androidx.core.app.TaskStackBuilder\",\"android.support.v4.content.AsyncTaskLoader\":\"androidx.loader.content.AsyncTaskLoader\",\"android.support.v4.content.ContentResolverCompat\":\"androidx.core.content.ContentResolverCompat\",\"android.support.v4.content.ContextCompat\":\"androidx.core.content.ContextCompat\",\"android.support.v4.content.CursorLoader\":\"androidx.loader.content.CursorLoader\",\"android.support.v4.content.FileProvider\":\"androidx.core.content.FileProvider\",\"android.support.v4.content.IntentCompat\":\"androidx.core.content.IntentCompat\",\"android.support.v4.content.Loader\":\"androidx.loader.content.Loader\",\"android.support.v4.content.LocalBroadcastManager\":\"androidx.localbroadcastmanager.content.LocalBroadcastManager\",\"android.support.v4.content.MimeTypeFilter\":\"androidx.core.content.MimeTypeFilter\",\"android.support.v4.content.ModernAsyncTask\":\"androidx.loader.content.ModernAsyncTask\",\"android.support.v4.content.PermissionChecker\":\"androidx.core.content.PermissionChecker\",\"android.support.v4.content.pm.ActivityInfoCompat\":\"androidx.core.content.pm.ActivityInfoCompat\",\"android.support.v4.content.pm.PackageInfoCompat\":\"androidx.core.content.pm.PackageInfoCompat\",\"android.support.v4.content.pm.PermissionInfoCompat\":\"androidx.core.content.pm.PermissionInfoCompat\",\"android.support.v4.content.pm.ShortcutInfoCompat\":\"androidx.core.content.pm.ShortcutInfoCompat\",\"android.support.v4.content.pm.ShortcutManagerCompat\":\"androidx.core.content.pm.ShortcutManagerCompat\",\"android.support.v4.content.res.ColorStateListInflaterCompat\":\"androidx.core.content.res.ColorStateListInflaterCompat\",\"android.support.v4.content.res.ComplexColorCompat\":\"androidx.core.content.res.ComplexColorCompat\",\"android.support.v4.content.res.ConfigurationHelper\":\"androidx.core.content.res.ConfigurationHelper\",\"android.support.v4.content.res.FontResourcesParserCompat\":\"androidx.core.content.res.FontResourcesParserCompat\",\"android.support.v4.content.res.GradientColorInflaterCompat\":\"androidx.core.content.res.GradientColorInflaterCompat\",\"android.support.v4.content.res.GrowingArrayUtils\":\"androidx.core.content.res.GrowingArrayUtils\",\"android.support.v4.content.res.ResourcesCompat\":\"androidx.core.content.res.ResourcesCompat\",\"android.support.v4.content.res.TypedArrayUtils\":\"androidx.core.content.res.TypedArrayUtils\",\"android.support.v4.content.SharedPreferencesCompat\":\"androidx.core.content.SharedPreferencesCompat\",\"android.support.v4.content.WakefulBroadcastReceiver\":\"androidx.legacy.content.WakefulBroadcastReceiver\",\"android.support.v4.database.CursorWindowCompat\":\"androidx.core.database.CursorWindowCompat\",\"android.support.v4.database.DatabaseUtilsCompat\":\"androidx.core.database.DatabaseUtilsCompat\",\"android.support.v4.database.sqlite.SQLiteCursorCompat\":\"androidx.core.database.sqlite.SQLiteCursorCompat\",\"android.support.v4.graphics.BitmapCompat\":\"androidx.core.graphics.BitmapCompat\",\"android.support.v4.graphics.ColorUtils\":\"androidx.core.graphics.ColorUtils\",\"android.support.v4.graphics.drawable.DrawableCompat\":\"androidx.core.graphics.drawable.DrawableCompat\",\"android.support.v4.graphics.drawable.IconCompat\":\"androidx.core.graphics.drawable.IconCompat\",\"android.support.v4.graphics.drawable.IconCompatParcelizer\":\"android.support.v4.graphics.drawable.IconCompatParcelizer\",\"android.support.v4.graphics.drawable.RoundedBitmapDrawable\":\"androidx.core.graphics.drawable.RoundedBitmapDrawable\",\"android.support.v4.graphics.drawable.RoundedBitmapDrawable21\":\"androidx.core.graphics.drawable.RoundedBitmapDrawable21\",\"android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory\":\"androidx.core.graphics.drawable.RoundedBitmapDrawableFactory\",\"android.support.v4.graphics.drawable.TintAwareDrawable\":\"androidx.core.graphics.drawable.TintAwareDrawable\",\"android.support.v4.graphics.drawable.WrappedDrawable\":\"androidx.core.graphics.drawable.WrappedDrawable\",\"android.support.v4.graphics.drawable.WrappedDrawableApi14\":\"androidx.core.graphics.drawable.WrappedDrawableApi14\",\"android.support.v4.graphics.drawable.WrappedDrawableApi21\":\"androidx.core.graphics.drawable.WrappedDrawableApi21\",\"android.support.v4.graphics.PaintCompat\":\"androidx.core.graphics.PaintCompat\",\"android.support.v4.graphics.PathParser\":\"androidx.core.graphics.PathParser\",\"android.support.v4.graphics.PathSegment\":\"androidx.core.graphics.PathSegment\",\"android.support.v4.graphics.PathUtils\":\"androidx.core.graphics.PathUtils\",\"android.support.v4.graphics.TypefaceCompat\":\"androidx.core.graphics.TypefaceCompat\",\"android.support.v4.graphics.TypefaceCompatApi21Impl\":\"androidx.core.graphics.TypefaceCompatApi21Impl\",\"android.support.v4.graphics.TypefaceCompatApi24Impl\":\"androidx.core.graphics.TypefaceCompatApi24Impl\",\"android.support.v4.graphics.TypefaceCompatApi26Impl\":\"androidx.core.graphics.TypefaceCompatApi26Impl\",\"android.support.v4.graphics.TypefaceCompatApi28Impl\":\"androidx.core.graphics.TypefaceCompatApi28Impl\",\"android.support.v4.graphics.TypefaceCompatBaseImpl\":\"androidx.core.graphics.TypefaceCompatBaseImpl\",\"android.support.v4.graphics.TypefaceCompatUtil\":\"androidx.core.graphics.TypefaceCompatUtil\",\"android.support.v4.hardware.display.DisplayManagerCompat\":\"androidx.core.hardware.display.DisplayManagerCompat\",\"android.support.v4.hardware.fingerprint.FingerprintManagerCompat\":\"androidx.core.hardware.fingerprint.FingerprintManagerCompat\",\"android.support.v4.internal.view.SupportMenu\":\"androidx.core.internal.view.SupportMenu\",\"android.support.v4.internal.view.SupportMenuItem\":\"androidx.core.internal.view.SupportMenuItem\",\"android.support.v4.internal.view.SupportSubMenu\":\"androidx.core.internal.view.SupportSubMenu\",\"android.support.v4.math.MathUtils\":\"androidx.core.math.MathUtils\",\"android.support.v4.media.app.NotificationCompat\":\"androidx.media.app.NotificationCompat\",\"android.support.v4.media.AudioAttributesCompat\":\"androidx.media.AudioAttributesCompat\",\"android.support.v4.media.AudioAttributesImpl\":\"android.support.v4.media.AudioAttributesImpl\",\"android.support.v4.media.AudioAttributesImplApi21\":\"android.support.v4.media.AudioAttributesImplApi21\",\"android.support.v4.media.AudioAttributesImplBase\":\"android.support.v4.media.AudioAttributesImplBase\",\"android.support.v4.media.MediaBrowserCompat\":\"android.support.v4.media.MediaBrowserCompat\",\"android.support.v4.media.MediaBrowserCompatApi21\":\"android.support.v4.media.MediaBrowserCompatApi21\",\"android.support.v4.media.MediaBrowserCompatApi23\":\"android.support.v4.media.MediaBrowserCompatApi23\",\"android.support.v4.media.MediaBrowserCompatApi26\":\"android.support.v4.media.MediaBrowserCompatApi26\",\"android.support.v4.media.MediaBrowserCompatUtils\":\"androidx.media.MediaBrowserCompatUtils\",\"android.support.v4.media.MediaBrowserProtocol\":\"androidx.media.MediaBrowserProtocol\",\"android.support.v4.media.MediaBrowserServiceCompat\":\"androidx.media.MediaBrowserServiceCompat\",\"android.support.v4.media.MediaBrowserServiceCompatApi21\":\"androidx.media.MediaBrowserServiceCompatApi21\",\"android.support.v4.media.MediaBrowserServiceCompatApi23\":\"androidx.media.MediaBrowserServiceCompatApi23\",\"android.support.v4.media.MediaBrowserServiceCompatApi26\":\"androidx.media.MediaBrowserServiceCompatApi26\",\"android.support.v4.media.MediaDescriptionCompat\":\"android.support.v4.media.MediaDescriptionCompat\",\"android.support.v4.media.MediaDescriptionCompatApi21\":\"android.support.v4.media.MediaDescriptionCompatApi21\",\"android.support.v4.media.MediaDescriptionCompatApi23\":\"android.support.v4.media.MediaDescriptionCompatApi23\",\"android.support.v4.media.MediaMetadataCompat\":\"android.support.v4.media.MediaMetadataCompat\",\"android.support.v4.media.MediaMetadataCompatApi21\":\"android.support.v4.media.MediaMetadataCompatApi21\",\"android.support.v4.media.MediaSessionManager\":\"androidx.media.MediaSessionManager\",\"android.support.v4.media.MediaSessionManagerImplApi21\":\"androidx.media.MediaSessionManagerImplApi21\",\"android.support.v4.media.MediaSessionManagerImplApi28\":\"androidx.media.MediaSessionManagerImplApi28\",\"android.support.v4.media.MediaSessionManagerImplBase\":\"androidx.media.MediaSessionManagerImplBase\",\"android.support.v4.media.ParceledListSliceAdapterApi21\":\"android.support.v4.media.ParceledListSliceAdapterApi21\",\"android.support.v4.media.RatingCompat\":\"android.support.v4.media.RatingCompat\",\"android.support.v4.media.session.IMediaControllerCallback\":\"android.support.v4.media.session.IMediaControllerCallback\",\"android.support.v4.media.session.IMediaSession\":\"android.support.v4.media.session.IMediaSession\",\"android.support.v4.media.session.MediaButtonReceiver\":\"androidx.media.session.MediaButtonReceiver\",\"android.support.v4.media.session.MediaControllerCompat\":\"android.support.v4.media.session.MediaControllerCompat\",\"android.support.v4.media.session.MediaControllerCompatApi21\":\"android.support.v4.media.session.MediaControllerCompatApi21\",\"android.support.v4.media.session.MediaControllerCompatApi23\":\"android.support.v4.media.session.MediaControllerCompatApi23\",\"android.support.v4.media.session.MediaControllerCompatApi24\":\"android.support.v4.media.session.MediaControllerCompatApi24\",\"android.support.v4.media.session.MediaSessionCompat\":\"android.support.v4.media.session.MediaSessionCompat\",\"android.support.v4.media.session.MediaSessionCompatApi21\":\"android.support.v4.media.session.MediaSessionCompatApi21\",\"android.support.v4.media.session.MediaSessionCompatApi22\":\"android.support.v4.media.session.MediaSessionCompatApi22\",\"android.support.v4.media.session.MediaSessionCompatApi23\":\"android.support.v4.media.session.MediaSessionCompatApi23\",\"android.support.v4.media.session.MediaSessionCompatApi24\":\"android.support.v4.media.session.MediaSessionCompatApi24\",\"android.support.v4.media.session.ParcelableVolumeInfo\":\"android.support.v4.media.session.ParcelableVolumeInfo\",\"android.support.v4.media.session.PlaybackStateCompat\":\"android.support.v4.media.session.PlaybackStateCompat\",\"android.support.v4.media.session.PlaybackStateCompatApi21\":\"android.support.v4.media.session.PlaybackStateCompatApi21\",\"android.support.v4.media.session.PlaybackStateCompatApi22\":\"android.support.v4.media.session.PlaybackStateCompatApi22\",\"android.support.v4.media.VolumeProviderCompat\":\"androidx.media.VolumeProviderCompat\",\"android.support.v4.media.VolumeProviderCompatApi21\":\"androidx.media.VolumeProviderCompatApi21\",\"android.support.v4.net.ConnectivityManagerCompat\":\"androidx.core.net.ConnectivityManagerCompat\",\"android.support.v4.net.DatagramSocketWrapper\":\"androidx.core.net.DatagramSocketWrapper\",\"android.support.v4.net.TrafficStatsCompat\":\"androidx.core.net.TrafficStatsCompat\",\"android.support.v4.os.BuildCompat\":\"androidx.core.os.BuildCompat\",\"android.support.v4.os.CancellationSignal\":\"androidx.core.os.CancellationSignal\",\"android.support.v4.os.ConfigurationCompat\":\"androidx.core.os.ConfigurationCompat\",\"android.support.v4.os.EnvironmentCompat\":\"androidx.core.os.EnvironmentCompat\",\"android.support.v4.os.HandlerCompat\":\"androidx.core.os.HandlerCompat\",\"android.support.v4.os.IResultReceiver\":\"androidx.core.os.IResultReceiver\",\"android.support.v4.os.LocaleHelper\":\"androidx.core.os.LocaleHelper\",\"android.support.v4.os.LocaleListCompat\":\"androidx.core.os.LocaleListCompat\",\"android.support.v4.os.LocaleListHelper\":\"androidx.core.os.LocaleListHelper\",\"android.support.v4.os.LocaleListInterface\":\"androidx.core.os.LocaleListInterface\",\"android.support.v4.os.OperationCanceledException\":\"androidx.core.os.OperationCanceledException\",\"android.support.v4.os.ParcelableCompat\":\"androidx.core.os.ParcelableCompat\",\"android.support.v4.os.ParcelableCompatCreatorCallbacks\":\"androidx.core.os.ParcelableCompatCreatorCallbacks\",\"android.support.v4.os.ParcelCompat\":\"androidx.core.os.ParcelCompat\",\"android.support.v4.os.ResultReceiver\":\"androidx.core.os.ResultReceiver\",\"android.support.v4.os.TraceCompat\":\"androidx.core.os.TraceCompat\",\"android.support.v4.os.UserManagerCompat\":\"androidx.core.os.UserManagerCompat\",\"android.support.v4.print.PrintHelper\":\"androidx.print.PrintHelper\",\"android.support.v4.provider.DocumentFile\":\"androidx.documentfile.provider.DocumentFile\",\"android.support.v4.provider.DocumentsContractApi19\":\"androidx.documentfile.provider.DocumentsContractApi19\",\"android.support.v4.provider.FontRequest\":\"androidx.core.provider.FontRequest\",\"android.support.v4.provider.FontsContractCompat\":\"androidx.core.provider.FontsContractCompat\",\"android.support.v4.provider.RawDocumentFile\":\"androidx.documentfile.provider.RawDocumentFile\",\"android.support.v4.provider.SelfDestructiveThread\":\"androidx.core.provider.SelfDestructiveThread\",\"android.support.v4.provider.SingleDocumentFile\":\"androidx.documentfile.provider.SingleDocumentFile\",\"android.support.v4.provider.TreeDocumentFile\":\"androidx.documentfile.provider.TreeDocumentFile\",\"android.support.v4.text.BidiFormatter\":\"androidx.core.text.BidiFormatter\",\"android.support.v4.text.HtmlCompat\":\"androidx.core.text.HtmlCompat\",\"android.support.v4.text.ICUCompat\":\"androidx.core.text.ICUCompat\",\"android.support.v4.text.PrecomputedTextCompat\":\"androidx.core.text.PrecomputedTextCompat\",\"android.support.v4.text.TextDirectionHeuristicCompat\":\"androidx.core.text.TextDirectionHeuristicCompat\",\"android.support.v4.text.TextDirectionHeuristicsCompat\":\"androidx.core.text.TextDirectionHeuristicsCompat\",\"android.support.v4.text.TextUtilsCompat\":\"androidx.core.text.TextUtilsCompat\",\"android.support.v4.text.util.FindAddress\":\"androidx.core.text.util.FindAddress\",\"android.support.v4.text.util.LinkifyCompat\":\"androidx.core.text.util.LinkifyCompat\",\"android.support.v4.util.ArrayMap\":\"androidx.collection.ArrayMap\",\"android.support.v4.util.ArraySet\":\"androidx.collection.ArraySet\",\"android.support.v4.util.AtomicFile\":\"androidx.core.util.AtomicFile\",\"android.support.v4.util.CircularArray\":\"androidx.collection.CircularArray\",\"android.support.v4.util.CircularIntArray\":\"androidx.collection.CircularIntArray\",\"android.support.v4.util.Consumer\":\"androidx.core.util.Consumer\",\"android.support.v4.util.ContainerHelpers\":\"androidx.collection.ContainerHelpers\",\"android.support.v4.util.DebugUtils\":\"androidx.core.util.DebugUtils\",\"android.support.v4.util.LogWriter\":\"androidx.core.util.LogWriter\",\"android.support.v4.util.LongSparseArray\":\"androidx.collection.LongSparseArray\",\"android.support.v4.util.LruCache\":\"androidx.collection.LruCache\",\"android.support.v4.util.MapCollections\":\"androidx.collection.MapCollections\",\"android.support.v4.util.ObjectsCompat\":\"androidx.core.util.ObjectsCompat\",\"android.support.v4.util.Pair\":\"androidx.core.util.Pair\",\"android.support.v4.util.PatternsCompat\":\"androidx.core.util.PatternsCompat\",\"android.support.v4.util.Pools\":\"androidx.core.util.Pools\",\"android.support.v4.util.Preconditions\":\"androidx.core.util.Preconditions\",\"android.support.v4.util.SimpleArrayMap\":\"androidx.collection.SimpleArrayMap\",\"android.support.v4.util.SparseArrayCompat\":\"androidx.collection.SparseArrayCompat\",\"android.support.v4.util.TimeUtils\":\"androidx.core.util.TimeUtils\",\"android.support.v4.view.AbsSavedState\":\"androidx.customview.view.AbsSavedState\",\"android.support.v4.view.accessibility.AccessibilityEventCompat\":\"androidx.core.view.accessibility.AccessibilityEventCompat\",\"android.support.v4.view.accessibility.AccessibilityManagerCompat\":\"androidx.core.view.accessibility.AccessibilityManagerCompat\",\"android.support.v4.view.accessibility.AccessibilityNodeInfoCompat\":\"androidx.core.view.accessibility.AccessibilityNodeInfoCompat\",\"android.support.v4.view.accessibility.AccessibilityNodeProviderCompat\":\"androidx.core.view.accessibility.AccessibilityNodeProviderCompat\",\"android.support.v4.view.accessibility.AccessibilityRecordCompat\":\"androidx.core.view.accessibility.AccessibilityRecordCompat\",\"android.support.v4.view.accessibility.AccessibilityWindowInfoCompat\":\"androidx.core.view.accessibility.AccessibilityWindowInfoCompat\",\"android.support.v4.view.AccessibilityDelegateCompat\":\"androidx.core.view.AccessibilityDelegateCompat\",\"android.support.v4.view.ActionProvider\":\"androidx.core.view.ActionProvider\",\"android.support.v4.view.animation.FastOutLinearInInterpolator\":\"androidx.interpolator.view.animation.FastOutLinearInInterpolator\",\"android.support.v4.view.animation.FastOutSlowInInterpolator\":\"androidx.interpolator.view.animation.FastOutSlowInInterpolator\",\"android.support.v4.view.animation.LinearOutSlowInInterpolator\":\"androidx.interpolator.view.animation.LinearOutSlowInInterpolator\",\"android.support.v4.view.animation.LookupTableInterpolator\":\"androidx.interpolator.view.animation.LookupTableInterpolator\",\"android.support.v4.view.animation.PathInterpolatorApi14\":\"androidx.core.view.animation.PathInterpolatorApi14\",\"android.support.v4.view.animation.PathInterpolatorCompat\":\"androidx.core.view.animation.PathInterpolatorCompat\",\"android.support.v4.view.AsyncLayoutInflater\":\"androidx.asynclayoutinflater.view.AsyncLayoutInflater\",\"android.support.v4.view.DisplayCutoutCompat\":\"androidx.core.view.DisplayCutoutCompat\",\"android.support.v4.view.GestureDetectorCompat\":\"androidx.core.view.GestureDetectorCompat\",\"android.support.v4.view.GravityCompat\":\"androidx.core.view.GravityCompat\",\"android.support.v4.view.InputDeviceCompat\":\"androidx.core.view.InputDeviceCompat\",\"android.support.v4.view.KeyEventDispatcher\":\"androidx.core.view.KeyEventDispatcher\",\"android.support.v4.view.LayoutInflaterCompat\":\"androidx.core.view.LayoutInflaterCompat\",\"android.support.v4.view.LayoutInflaterFactory\":\"androidx.core.view.LayoutInflaterFactory\",\"android.support.v4.view.MarginLayoutParamsCompat\":\"androidx.core.view.MarginLayoutParamsCompat\",\"android.support.v4.view.MenuCompat\":\"androidx.core.view.MenuCompat\",\"android.support.v4.view.MenuItemCompat\":\"androidx.core.view.MenuItemCompat\",\"android.support.v4.view.MotionEventCompat\":\"androidx.core.view.MotionEventCompat\",\"android.support.v4.view.NestedScrollingChild\":\"androidx.core.view.NestedScrollingChild\",\"android.support.v4.view.NestedScrollingChild2\":\"androidx.core.view.NestedScrollingChild2\",\"android.support.v4.view.NestedScrollingChildHelper\":\"androidx.core.view.NestedScrollingChildHelper\",\"android.support.v4.view.NestedScrollingParent\":\"androidx.core.view.NestedScrollingParent\",\"android.support.v4.view.NestedScrollingParent2\":\"androidx.core.view.NestedScrollingParent2\",\"android.support.v4.view.NestedScrollingParentHelper\":\"androidx.core.view.NestedScrollingParentHelper\",\"android.support.v4.view.OnApplyWindowInsetsListener\":\"androidx.core.view.OnApplyWindowInsetsListener\",\"android.support.v4.view.PagerAdapter\":\"androidx.viewpager.widget.PagerAdapter\",\"android.support.v4.view.PagerTabStrip\":\"androidx.viewpager.widget.PagerTabStrip\",\"android.support.v4.view.PagerTitleStrip\":\"androidx.viewpager.widget.PagerTitleStrip\",\"android.support.v4.view.PointerIconCompat\":\"androidx.core.view.PointerIconCompat\",\"android.support.v4.view.ScaleGestureDetectorCompat\":\"androidx.core.view.ScaleGestureDetectorCompat\",\"android.support.v4.view.ScrollingView\":\"androidx.core.view.ScrollingView\",\"android.support.v4.view.TintableBackgroundView\":\"androidx.core.view.TintableBackgroundView\",\"android.support.v4.view.VelocityTrackerCompat\":\"androidx.core.view.VelocityTrackerCompat\",\"android.support.v4.view.ViewCompat\":\"androidx.core.view.ViewCompat\",\"android.support.v4.view.ViewConfigurationCompat\":\"androidx.core.view.ViewConfigurationCompat\",\"android.support.v4.view.ViewGroupCompat\":\"androidx.core.view.ViewGroupCompat\",\"android.support.v4.view.ViewPager\":\"androidx.viewpager.widget.ViewPager\",\"android.support.v4.view.ViewParentCompat\":\"androidx.core.view.ViewParentCompat\",\"android.support.v4.view.ViewPropertyAnimatorCompat\":\"androidx.core.view.ViewPropertyAnimatorCompat\",\"android.support.v4.view.ViewPropertyAnimatorListener\":\"androidx.core.view.ViewPropertyAnimatorListener\",\"android.support.v4.view.ViewPropertyAnimatorListenerAdapter\":\"androidx.core.view.ViewPropertyAnimatorListenerAdapter\",\"android.support.v4.view.ViewPropertyAnimatorUpdateListener\":\"androidx.core.view.ViewPropertyAnimatorUpdateListener\",\"android.support.v4.view.WindowCompat\":\"androidx.core.view.WindowCompat\",\"android.support.v4.view.WindowInsetsCompat\":\"androidx.core.view.WindowInsetsCompat\",\"android.support.v4.widget.AutoScrollHelper\":\"androidx.core.widget.AutoScrollHelper\",\"android.support.v4.widget.AutoSizeableTextView\":\"androidx.core.widget.AutoSizeableTextView\",\"android.support.v4.widget.CircleImageView\":\"androidx.swiperefreshlayout.widget.CircleImageView\",\"android.support.v4.widget.CircularProgressDrawable\":\"androidx.swiperefreshlayout.widget.CircularProgressDrawable\",\"android.support.v4.widget.CompoundButtonCompat\":\"androidx.core.widget.CompoundButtonCompat\",\"android.support.v4.widget.ContentLoadingProgressBar\":\"androidx.core.widget.ContentLoadingProgressBar\",\"android.support.v4.widget.CursorAdapter\":\"androidx.cursoradapter.widget.CursorAdapter\",\"android.support.v4.widget.CursorFilter\":\"androidx.cursoradapter.widget.CursorFilter\",\"android.support.v4.widget.DirectedAcyclicGraph\":\"androidx.coordinatorlayout.widget.DirectedAcyclicGraph\",\"android.support.v4.widget.DrawerLayout\":\"androidx.drawerlayout.widget.DrawerLayout\",\"android.support.v4.widget.EdgeEffectCompat\":\"androidx.core.widget.EdgeEffectCompat\",\"android.support.v4.widget.ExploreByTouchHelper\":\"androidx.customview.widget.ExploreByTouchHelper\",\"android.support.v4.widget.FocusStrategy\":\"androidx.customview.widget.FocusStrategy\",\"android.support.v4.widget.ImageViewCompat\":\"androidx.core.widget.ImageViewCompat\",\"android.support.v4.widget.ListPopupWindowCompat\":\"androidx.core.widget.ListPopupWindowCompat\",\"android.support.v4.widget.ListViewAutoScrollHelper\":\"androidx.core.widget.ListViewAutoScrollHelper\",\"android.support.v4.widget.ListViewCompat\":\"androidx.core.widget.ListViewCompat\",\"android.support.v4.widget.NestedScrollView\":\"androidx.core.widget.NestedScrollView\",\"android.support.v4.widget.PopupMenuCompat\":\"androidx.core.widget.PopupMenuCompat\",\"android.support.v4.widget.PopupWindowCompat\":\"androidx.core.widget.PopupWindowCompat\",\"android.support.v4.widget.ResourceCursorAdapter\":\"androidx.cursoradapter.widget.ResourceCursorAdapter\",\"android.support.v4.widget.ScrollerCompat\":\"androidx.core.widget.ScrollerCompat\",\"android.support.v4.widget.SimpleCursorAdapter\":\"androidx.cursoradapter.widget.SimpleCursorAdapter\",\"android.support.v4.widget.SlidingPaneLayout\":\"androidx.slidingpanelayout.widget.SlidingPaneLayout\",\"android.support.v4.widget.Space\":\"androidx.legacy.widget.Space\",\"android.support.v4.widget.SwipeRefreshLayout\":\"androidx.swiperefreshlayout.widget.SwipeRefreshLayout\",\"android.support.v4.widget.TextViewCompat\":\"androidx.core.widget.TextViewCompat\",\"android.support.v4.widget.TintableCompoundButton\":\"androidx.core.widget.TintableCompoundButton\",\"android.support.v4.widget.TintableImageSourceView\":\"androidx.core.widget.TintableImageSourceView\",\"android.support.v4.widget.ViewDragHelper\":\"androidx.customview.widget.ViewDragHelper\",\"android.support.v4.widget.ViewGroupUtils\":\"androidx.coordinatorlayout.widget.ViewGroupUtils\",\"android.support.v7.app.ActionBar\":\"androidx.appcompat.app.ActionBar\",\"android.support.v7.app.ActionBarDrawerToggle\":\"androidx.appcompat.app.ActionBarDrawerToggle\",\"android.support.v7.app.ActionBarDrawerToggleHoneycomb\":\"androidx.appcompat.app.ActionBarDrawerToggleHoneycomb\",\"android.support.v7.app.AlertController\":\"androidx.appcompat.app.AlertController\",\"android.support.v7.app.AlertDialog\":\"androidx.appcompat.app.AlertDialog\",\"android.support.v7.app.AppCompatActivity\":\"androidx.appcompat.app.AppCompatActivity\",\"android.support.v7.app.AppCompatCallback\":\"androidx.appcompat.app.AppCompatCallback\",\"android.support.v7.app.AppCompatDelegate\":\"androidx.appcompat.app.AppCompatDelegate\",\"android.support.v7.app.AppCompatDelegateImpl\":\"androidx.appcompat.app.AppCompatDelegateImpl\",\"android.support.v7.app.AppCompatDialog\":\"androidx.appcompat.app.AppCompatDialog\",\"android.support.v7.app.AppCompatDialogFragment\":\"androidx.appcompat.app.AppCompatDialogFragment\",\"android.support.v7.app.AppCompatViewInflater\":\"androidx.appcompat.app.AppCompatViewInflater\",\"android.support.v7.app.MediaRouteActionProvider\":\"androidx.mediarouter.app.MediaRouteActionProvider\",\"android.support.v7.app.MediaRouteButton\":\"androidx.mediarouter.app.MediaRouteButton\",\"android.support.v7.app.MediaRouteCastDialog\":\"androidx.mediarouter.app.MediaRouteCastDialog\",\"android.support.v7.app.MediaRouteChooserDialog\":\"androidx.mediarouter.app.MediaRouteChooserDialog\",\"android.support.v7.app.MediaRouteChooserDialogFragment\":\"androidx.mediarouter.app.MediaRouteChooserDialogFragment\",\"android.support.v7.app.MediaRouteControllerDialog\":\"androidx.mediarouter.app.MediaRouteControllerDialog\",\"android.support.v7.app.MediaRouteControllerDialogFragment\":\"androidx.mediarouter.app.MediaRouteControllerDialogFragment\",\"android.support.v7.app.MediaRouteDevicePickerDialog\":\"androidx.mediarouter.app.MediaRouteDevicePickerDialog\",\"android.support.v7.app.MediaRouteDialogFactory\":\"androidx.mediarouter.app.MediaRouteDialogFactory\",\"android.support.v7.app.MediaRouteDialogHelper\":\"androidx.mediarouter.app.MediaRouteDialogHelper\",\"android.support.v7.app.MediaRouteDiscoveryFragment\":\"androidx.mediarouter.app.MediaRouteDiscoveryFragment\",\"android.support.v7.app.MediaRouteExpandCollapseButton\":\"androidx.mediarouter.app.MediaRouteExpandCollapseButton\",\"android.support.v7.app.MediaRouterThemeHelper\":\"androidx.mediarouter.app.MediaRouterThemeHelper\",\"android.support.v7.app.MediaRouteVolumeSlider\":\"androidx.mediarouter.app.MediaRouteVolumeSlider\",\"android.support.v7.app.NavItemSelectedListener\":\"androidx.appcompat.app.NavItemSelectedListener\",\"android.support.v7.app.OverlayListView\":\"androidx.mediarouter.app.OverlayListView\",\"android.support.v7.app.ResourcesFlusher\":\"androidx.appcompat.app.ResourcesFlusher\",\"android.support.v7.app.ToolbarActionBar\":\"androidx.appcompat.app.ToolbarActionBar\",\"android.support.v7.app.TwilightCalculator\":\"androidx.appcompat.app.TwilightCalculator\",\"android.support.v7.app.TwilightManager\":\"androidx.appcompat.app.TwilightManager\",\"android.support.v7.app.WindowDecorActionBar\":\"androidx.appcompat.app.WindowDecorActionBar\",\"android.support.v7.appcompat.R\":\"androidx.appcompat.R\",\"android.support.v7.cardview.R\":\"androidx.cardview.R\",\"android.support.v7.content.res.AppCompatResources\":\"androidx.appcompat.content.res.AppCompatResources\",\"android.support.v7.graphics.ColorCutQuantizer\":\"androidx.palette.graphics.ColorCutQuantizer\",\"android.support.v7.graphics.drawable.AnimatedStateListDrawableCompat\":\"androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat\",\"android.support.v7.graphics.drawable.DrawableContainer\":\"androidx.appcompat.graphics.drawable.DrawableContainer\",\"android.support.v7.graphics.drawable.DrawableWrapper\":\"androidx.appcompat.graphics.drawable.DrawableWrapper\",\"android.support.v7.graphics.drawable.DrawerArrowDrawable\":\"androidx.appcompat.graphics.drawable.DrawerArrowDrawable\",\"android.support.v7.graphics.drawable.StateListDrawable\":\"androidx.appcompat.graphics.drawable.StateListDrawable\",\"android.support.v7.graphics.Palette\":\"androidx.palette.graphics.Palette\",\"android.support.v7.graphics.Target\":\"androidx.palette.graphics.Target\",\"android.support.v7.gridlayout.R\":\"androidx.gridlayout.R\",\"android.support.v7.internal.widget.PreferenceImageView\":\"androidx.preference.internal.PreferenceImageView\",\"android.support.v7.media.MediaControlIntent\":\"androidx.mediarouter.media.MediaControlIntent\",\"android.support.v7.media.MediaItemMetadata\":\"androidx.mediarouter.media.MediaItemMetadata\",\"android.support.v7.media.MediaItemStatus\":\"androidx.mediarouter.media.MediaItemStatus\",\"android.support.v7.media.MediaRouteDescriptor\":\"androidx.mediarouter.media.MediaRouteDescriptor\",\"android.support.v7.media.MediaRouteDiscoveryRequest\":\"androidx.mediarouter.media.MediaRouteDiscoveryRequest\",\"android.support.v7.media.MediaRouteProvider\":\"androidx.mediarouter.media.MediaRouteProvider\",\"android.support.v7.media.MediaRouteProviderDescriptor\":\"androidx.mediarouter.media.MediaRouteProviderDescriptor\",\"android.support.v7.media.MediaRouteProviderProtocol\":\"androidx.mediarouter.media.MediaRouteProviderProtocol\",\"android.support.v7.media.MediaRouteProviderService\":\"androidx.mediarouter.media.MediaRouteProviderService\",\"android.support.v7.media.MediaRouter\":\"androidx.mediarouter.media.MediaRouter\",\"android.support.v7.media.MediaRouterApi24\":\"androidx.mediarouter.media.MediaRouterApi24\",\"android.support.v7.media.MediaRouterJellybean\":\"androidx.mediarouter.media.MediaRouterJellybean\",\"android.support.v7.media.MediaRouterJellybeanMr1\":\"androidx.mediarouter.media.MediaRouterJellybeanMr1\",\"android.support.v7.media.MediaRouterJellybeanMr2\":\"androidx.mediarouter.media.MediaRouterJellybeanMr2\",\"android.support.v7.media.MediaRouteSelector\":\"androidx.mediarouter.media.MediaRouteSelector\",\"android.support.v7.media.MediaSessionStatus\":\"androidx.mediarouter.media.MediaSessionStatus\",\"android.support.v7.media.RegisteredMediaRouteProvider\":\"androidx.mediarouter.media.RegisteredMediaRouteProvider\",\"android.support.v7.media.RegisteredMediaRouteProviderWatcher\":\"androidx.mediarouter.media.RegisteredMediaRouteProviderWatcher\",\"android.support.v7.media.RemoteControlClientCompat\":\"androidx.mediarouter.media.RemoteControlClientCompat\",\"android.support.v7.media.RemotePlaybackClient\":\"androidx.mediarouter.media.RemotePlaybackClient\",\"android.support.v7.media.RouteMediaPlayerConnector\":\"androidx.mediarouter.media.RouteMediaPlayerConnector\",\"android.support.v7.media.SystemMediaRouteProvider\":\"androidx.mediarouter.media.SystemMediaRouteProvider\",\"android.support.v7.mediarouter.R\":\"androidx.mediarouter.R\",\"android.support.v7.preference.AndroidResources\":\"androidx.preference.AndroidResources\",\"android.support.v7.preference.CheckBoxPreference\":\"androidx.preference.CheckBoxPreference\",\"android.support.v7.preference.CollapsiblePreferenceGroupController\":\"androidx.preference.CollapsiblePreferenceGroupController\",\"android.support.v7.preference.DialogPreference\":\"androidx.preference.DialogPreference\",\"android.support.v7.preference.DropDownPreference\":\"androidx.preference.DropDownPreference\",\"android.support.v7.preference.EditTextPreference\":\"androidx.preference.EditTextPreference\",\"android.support.v7.preference.EditTextPreferenceDialogFragmentCompat\":\"androidx.preference.EditTextPreferenceDialogFragmentCompat\",\"android.support.v7.preference.internal.AbstractMultiSelectListPreference\":\"androidx.preference.internal.AbstractMultiSelectListPreference\",\"android.support.v7.preference.ListPreference\":\"androidx.preference.ListPreference\",\"android.support.v7.preference.ListPreferenceDialogFragmentCompat\":\"androidx.preference.ListPreferenceDialogFragmentCompat\",\"android.support.v7.preference.MultiSelectListPreferenceDialogFragmentCompat\":\"androidx.preference.MultiSelectListPreferenceDialogFragmentCompat\",\"android.support.v7.preference.Preference\":\"androidx.preference.Preference\",\"android.support.v7.preference.PreferenceCategory\":\"androidx.preference.PreferenceCategory\",\"android.support.v7.preference.PreferenceDataStore\":\"androidx.preference.PreferenceDataStore\",\"android.support.v7.preference.PreferenceDialogFragmentCompat\":\"androidx.preference.PreferenceDialogFragmentCompat\",\"android.support.v7.preference.PreferenceFragmentCompat\":\"androidx.preference.PreferenceFragmentCompat\",\"android.support.v7.preference.PreferenceGroup\":\"androidx.preference.PreferenceGroup\",\"android.support.v7.preference.PreferenceGroupAdapter\":\"androidx.preference.PreferenceGroupAdapter\",\"android.support.v7.preference.PreferenceInflater\":\"androidx.preference.PreferenceInflater\",\"android.support.v7.preference.PreferenceManager\":\"androidx.preference.PreferenceManager\",\"android.support.v7.preference.PreferenceRecyclerViewAccessibilityDelegate\":\"androidx.preference.PreferenceRecyclerViewAccessibilityDelegate\",\"android.support.v7.preference.PreferenceScreen\":\"androidx.preference.PreferenceScreen\",\"android.support.v7.preference.PreferenceViewHolder\":\"androidx.preference.PreferenceViewHolder\",\"android.support.v7.preference.R\":\"androidx.preference.R\",\"android.support.v7.preference.SeekBarPreference\":\"androidx.preference.SeekBarPreference\",\"android.support.v7.preference.SwitchPreferenceCompat\":\"androidx.preference.SwitchPreferenceCompat\",\"android.support.v7.preference.TwoStatePreference\":\"androidx.preference.TwoStatePreference\",\"android.support.v7.preference.UnPressableLinearLayout\":\"androidx.preference.UnPressableLinearLayout\",\"android.support.v7.recyclerview.extensions.AsyncDifferConfig\":\"androidx.recyclerview.widget.AsyncDifferConfig\",\"android.support.v7.recyclerview.extensions.AsyncListDiffer\":\"androidx.recyclerview.widget.AsyncListDiffer\",\"android.support.v7.recyclerview.extensions.ListAdapter\":\"androidx.recyclerview.widget.ListAdapter\",\"android.support.v7.recyclerview.R\":\"androidx.recyclerview.R\",\"android.support.v7.text.AllCapsTransformationMethod\":\"androidx.appcompat.text.AllCapsTransformationMethod\",\"android.support.v7.util.AdapterListUpdateCallback\":\"androidx.recyclerview.widget.AdapterListUpdateCallback\",\"android.support.v7.util.AsyncListUtil\":\"androidx.recyclerview.widget.AsyncListUtil\",\"android.support.v7.util.BatchingListUpdateCallback\":\"androidx.recyclerview.widget.BatchingListUpdateCallback\",\"android.support.v7.util.DiffUtil\":\"androidx.recyclerview.widget.DiffUtil\",\"android.support.v7.util.ListUpdateCallback\":\"androidx.recyclerview.widget.ListUpdateCallback\",\"android.support.v7.util.MessageThreadUtil\":\"androidx.recyclerview.widget.MessageThreadUtil\",\"android.support.v7.util.SortedList\":\"androidx.recyclerview.widget.SortedList\",\"android.support.v7.util.ThreadUtil\":\"androidx.recyclerview.widget.ThreadUtil\",\"android.support.v7.util.TileList\":\"androidx.recyclerview.widget.TileList\",\"android.support.v7.view.ActionBarPolicy\":\"androidx.appcompat.view.ActionBarPolicy\",\"android.support.v7.view.ActionMode\":\"androidx.appcompat.view.ActionMode\",\"android.support.v7.view.CollapsibleActionView\":\"androidx.appcompat.view.CollapsibleActionView\",\"android.support.v7.view.ContextThemeWrapper\":\"androidx.appcompat.view.ContextThemeWrapper\",\"android.support.v7.view.menu.ActionMenuItem\":\"androidx.appcompat.view.menu.ActionMenuItem\",\"android.support.v7.view.menu.ActionMenuItemView\":\"androidx.appcompat.view.menu.ActionMenuItemView\",\"android.support.v7.view.menu.BaseMenuPresenter\":\"androidx.appcompat.view.menu.BaseMenuPresenter\",\"android.support.v7.view.menu.BaseMenuWrapper\":\"androidx.appcompat.view.menu.BaseMenuWrapper\",\"android.support.v7.view.menu.BaseWrapper\":\"androidx.appcompat.view.menu.BaseWrapper\",\"android.support.v7.view.menu.CascadingMenuPopup\":\"androidx.appcompat.view.menu.CascadingMenuPopup\",\"android.support.v7.view.menu.ExpandedMenuView\":\"androidx.appcompat.view.menu.ExpandedMenuView\",\"android.support.v7.view.menu.ListMenuItemView\":\"androidx.appcompat.view.menu.ListMenuItemView\",\"android.support.v7.view.menu.ListMenuPresenter\":\"androidx.appcompat.view.menu.ListMenuPresenter\",\"android.support.v7.view.menu.MenuAdapter\":\"androidx.appcompat.view.menu.MenuAdapter\",\"android.support.v7.view.menu.MenuBuilder\":\"androidx.appcompat.view.menu.MenuBuilder\",\"android.support.v7.view.menu.MenuDialogHelper\":\"androidx.appcompat.view.menu.MenuDialogHelper\",\"android.support.v7.view.menu.MenuHelper\":\"androidx.appcompat.view.menu.MenuHelper\",\"android.support.v7.view.menu.MenuItemImpl\":\"androidx.appcompat.view.menu.MenuItemImpl\",\"android.support.v7.view.menu.MenuItemWrapperICS\":\"androidx.appcompat.view.menu.MenuItemWrapperICS\",\"android.support.v7.view.menu.MenuItemWrapperJB\":\"androidx.appcompat.view.menu.MenuItemWrapperJB\",\"android.support.v7.view.menu.MenuPopup\":\"androidx.appcompat.view.menu.MenuPopup\",\"android.support.v7.view.menu.MenuPopupHelper\":\"androidx.appcompat.view.menu.MenuPopupHelper\",\"android.support.v7.view.menu.MenuPresenter\":\"androidx.appcompat.view.menu.MenuPresenter\",\"android.support.v7.view.menu.MenuView\":\"androidx.appcompat.view.menu.MenuView\",\"android.support.v7.view.menu.MenuWrapperFactory\":\"androidx.appcompat.view.menu.MenuWrapperFactory\",\"android.support.v7.view.menu.MenuWrapperICS\":\"androidx.appcompat.view.menu.MenuWrapperICS\",\"android.support.v7.view.menu.ShowableListMenu\":\"androidx.appcompat.view.menu.ShowableListMenu\",\"android.support.v7.view.menu.StandardMenuPopup\":\"androidx.appcompat.view.menu.StandardMenuPopup\",\"android.support.v7.view.menu.SubMenuBuilder\":\"androidx.appcompat.view.menu.SubMenuBuilder\",\"android.support.v7.view.menu.SubMenuWrapperICS\":\"androidx.appcompat.view.menu.SubMenuWrapperICS\",\"android.support.v7.view.StandaloneActionMode\":\"androidx.appcompat.view.StandaloneActionMode\",\"android.support.v7.view.SupportActionModeWrapper\":\"androidx.appcompat.view.SupportActionModeWrapper\",\"android.support.v7.view.SupportMenuInflater\":\"androidx.appcompat.view.SupportMenuInflater\",\"android.support.v7.view.ViewPropertyAnimatorCompatSet\":\"androidx.appcompat.view.ViewPropertyAnimatorCompatSet\",\"android.support.v7.view.WindowCallbackWrapper\":\"androidx.appcompat.view.WindowCallbackWrapper\",\"android.support.v7.widget.AbsActionBarView\":\"androidx.appcompat.widget.AbsActionBarView\",\"android.support.v7.widget.ActionBarBackgroundDrawable\":\"androidx.appcompat.widget.ActionBarBackgroundDrawable\",\"android.support.v7.widget.ActionBarContainer\":\"androidx.appcompat.widget.ActionBarContainer\",\"android.support.v7.widget.ActionBarContextView\":\"androidx.appcompat.widget.ActionBarContextView\",\"android.support.v7.widget.ActionBarOverlayLayout\":\"androidx.appcompat.widget.ActionBarOverlayLayout\",\"android.support.v7.widget.ActionMenuPresenter\":\"androidx.appcompat.widget.ActionMenuPresenter\",\"android.support.v7.widget.ActionMenuView\":\"androidx.appcompat.widget.ActionMenuView\",\"android.support.v7.widget.ActivityChooserModel\":\"androidx.appcompat.widget.ActivityChooserModel\",\"android.support.v7.widget.ActivityChooserView\":\"androidx.appcompat.widget.ActivityChooserView\",\"android.support.v7.widget.AdapterHelper\":\"androidx.recyclerview.widget.AdapterHelper\",\"android.support.v7.widget.AlertDialogLayout\":\"androidx.appcompat.widget.AlertDialogLayout\",\"android.support.v7.widget.AppCompatAutoCompleteTextView\":\"androidx.appcompat.widget.AppCompatAutoCompleteTextView\",\"android.support.v7.widget.AppCompatBackgroundHelper\":\"androidx.appcompat.widget.AppCompatBackgroundHelper\",\"android.support.v7.widget.AppCompatButton\":\"androidx.appcompat.widget.AppCompatButton\",\"android.support.v7.widget.AppCompatCheckBox\":\"androidx.appcompat.widget.AppCompatCheckBox\",\"android.support.v7.widget.AppCompatCheckedTextView\":\"androidx.appcompat.widget.AppCompatCheckedTextView\",\"android.support.v7.widget.AppCompatCompoundButtonHelper\":\"androidx.appcompat.widget.AppCompatCompoundButtonHelper\",\"android.support.v7.widget.AppCompatDrawableManager\":\"androidx.appcompat.widget.AppCompatDrawableManager\",\"android.support.v7.widget.AppCompatEditText\":\"androidx.appcompat.widget.AppCompatEditText\",\"android.support.v7.widget.AppCompatHintHelper\":\"androidx.appcompat.widget.AppCompatHintHelper\",\"android.support.v7.widget.AppCompatImageButton\":\"androidx.appcompat.widget.AppCompatImageButton\",\"android.support.v7.widget.AppCompatImageHelper\":\"androidx.appcompat.widget.AppCompatImageHelper\",\"android.support.v7.widget.AppCompatImageView\":\"androidx.appcompat.widget.AppCompatImageView\",\"android.support.v7.widget.AppCompatMultiAutoCompleteTextView\":\"androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView\",\"android.support.v7.widget.AppCompatPopupWindow\":\"androidx.appcompat.widget.AppCompatPopupWindow\",\"android.support.v7.widget.AppCompatProgressBarHelper\":\"androidx.appcompat.widget.AppCompatProgressBarHelper\",\"android.support.v7.widget.AppCompatRadioButton\":\"androidx.appcompat.widget.AppCompatRadioButton\",\"android.support.v7.widget.AppCompatRatingBar\":\"androidx.appcompat.widget.AppCompatRatingBar\",\"android.support.v7.widget.AppCompatSeekBar\":\"androidx.appcompat.widget.AppCompatSeekBar\",\"android.support.v7.widget.AppCompatSeekBarHelper\":\"androidx.appcompat.widget.AppCompatSeekBarHelper\",\"android.support.v7.widget.AppCompatSpinner\":\"androidx.appcompat.widget.AppCompatSpinner\",\"android.support.v7.widget.AppCompatTextHelper\":\"androidx.appcompat.widget.AppCompatTextHelper\",\"android.support.v7.widget.AppCompatTextView\":\"androidx.appcompat.widget.AppCompatTextView\",\"android.support.v7.widget.AppCompatTextViewAutoSizeHelper\":\"androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper\",\"android.support.v7.widget.ButtonBarLayout\":\"androidx.appcompat.widget.ButtonBarLayout\",\"android.support.v7.widget.CardView\":\"androidx.cardview.widget.CardView\",\"android.support.v7.widget.CardViewApi17Impl\":\"androidx.cardview.widget.CardViewApi17Impl\",\"android.support.v7.widget.CardViewApi21Impl\":\"androidx.cardview.widget.CardViewApi21Impl\",\"android.support.v7.widget.CardViewBaseImpl\":\"androidx.cardview.widget.CardViewBaseImpl\",\"android.support.v7.widget.CardViewDelegate\":\"androidx.cardview.widget.CardViewDelegate\",\"android.support.v7.widget.CardViewImpl\":\"androidx.cardview.widget.CardViewImpl\",\"android.support.v7.widget.ChildHelper\":\"androidx.recyclerview.widget.ChildHelper\",\"android.support.v7.widget.ContentFrameLayout\":\"androidx.appcompat.widget.ContentFrameLayout\",\"android.support.v7.widget.DecorContentParent\":\"androidx.appcompat.widget.DecorContentParent\",\"android.support.v7.widget.DecorToolbar\":\"androidx.appcompat.widget.DecorToolbar\",\"android.support.v7.widget.DefaultItemAnimator\":\"androidx.recyclerview.widget.DefaultItemAnimator\",\"android.support.v7.widget.DialogTitle\":\"androidx.appcompat.widget.DialogTitle\",\"android.support.v7.widget.DividerItemDecoration\":\"androidx.recyclerview.widget.DividerItemDecoration\",\"android.support.v7.widget.DrawableUtils\":\"androidx.appcompat.widget.DrawableUtils\",\"android.support.v7.widget.DropDownListView\":\"androidx.appcompat.widget.DropDownListView\",\"android.support.v7.widget.FastScroller\":\"androidx.recyclerview.widget.FastScroller\",\"android.support.v7.widget.FitWindowsFrameLayout\":\"androidx.appcompat.widget.FitWindowsFrameLayout\",\"android.support.v7.widget.FitWindowsLinearLayout\":\"androidx.appcompat.widget.FitWindowsLinearLayout\",\"android.support.v7.widget.FitWindowsViewGroup\":\"androidx.appcompat.widget.FitWindowsViewGroup\",\"android.support.v7.widget.ForwardingListener\":\"androidx.appcompat.widget.ForwardingListener\",\"android.support.v7.widget.GapWorker\":\"androidx.recyclerview.widget.GapWorker\",\"android.support.v7.widget.GridLayout\":\"androidx.gridlayout.widget.GridLayout\",\"android.support.v7.widget.GridLayoutManager\":\"androidx.recyclerview.widget.GridLayoutManager\",\"android.support.v7.widget.helper.ItemTouchHelper\":\"androidx.recyclerview.widget.ItemTouchHelper\",\"android.support.v7.widget.helper.ItemTouchUIUtil\":\"androidx.recyclerview.widget.ItemTouchUIUtil\",\"android.support.v7.widget.helper.ItemTouchUIUtilImpl\":\"androidx.recyclerview.widget.ItemTouchUIUtilImpl\",\"android.support.v7.widget.LayoutState\":\"androidx.recyclerview.widget.LayoutState\",\"android.support.v7.widget.LinearLayoutCompat\":\"androidx.appcompat.widget.LinearLayoutCompat\",\"android.support.v7.widget.LinearLayoutManager\":\"androidx.recyclerview.widget.LinearLayoutManager\",\"android.support.v7.widget.LinearSmoothScroller\":\"androidx.recyclerview.widget.LinearSmoothScroller\",\"android.support.v7.widget.LinearSnapHelper\":\"androidx.recyclerview.widget.LinearSnapHelper\",\"android.support.v7.widget.ListPopupWindow\":\"androidx.appcompat.widget.ListPopupWindow\",\"android.support.v7.widget.MenuItemHoverListener\":\"androidx.appcompat.widget.MenuItemHoverListener\",\"android.support.v7.widget.MenuPopupWindow\":\"androidx.appcompat.widget.MenuPopupWindow\",\"android.support.v7.widget.OpReorderer\":\"androidx.recyclerview.widget.OpReorderer\",\"android.support.v7.widget.OrientationHelper\":\"androidx.recyclerview.widget.OrientationHelper\",\"android.support.v7.widget.PagerSnapHelper\":\"androidx.recyclerview.widget.PagerSnapHelper\",\"android.support.v7.widget.PopupMenu\":\"androidx.appcompat.widget.PopupMenu\",\"android.support.v7.widget.RecyclerView\":\"androidx.recyclerview.widget.RecyclerView\",\"android.support.v7.widget.RecyclerViewAccessibilityDelegate\":\"androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate\",\"android.support.v7.widget.ResourcesWrapper\":\"androidx.appcompat.widget.ResourcesWrapper\",\"android.support.v7.widget.RoundRectDrawable\":\"androidx.cardview.widget.RoundRectDrawable\",\"android.support.v7.widget.RoundRectDrawableWithShadow\":\"androidx.cardview.widget.RoundRectDrawableWithShadow\",\"android.support.v7.widget.RtlSpacingHelper\":\"androidx.appcompat.widget.RtlSpacingHelper\",\"android.support.v7.widget.ScrollbarHelper\":\"androidx.recyclerview.widget.ScrollbarHelper\",\"android.support.v7.widget.ScrollingTabContainerView\":\"androidx.appcompat.widget.ScrollingTabContainerView\",\"android.support.v7.widget.SearchView\":\"androidx.appcompat.widget.SearchView\",\"android.support.v7.widget.ShareActionProvider\":\"androidx.appcompat.widget.ShareActionProvider\",\"android.support.v7.widget.SimpleItemAnimator\":\"androidx.recyclerview.widget.SimpleItemAnimator\",\"android.support.v7.widget.SnapHelper\":\"androidx.recyclerview.widget.SnapHelper\",\"android.support.v7.widget.StaggeredGridLayoutManager\":\"androidx.recyclerview.widget.StaggeredGridLayoutManager\",\"android.support.v7.widget.SuggestionsAdapter\":\"androidx.appcompat.widget.SuggestionsAdapter\",\"android.support.v7.widget.SwitchCompat\":\"androidx.appcompat.widget.SwitchCompat\",\"android.support.v7.widget.ThemedSpinnerAdapter\":\"androidx.appcompat.widget.ThemedSpinnerAdapter\",\"android.support.v7.widget.ThemeUtils\":\"androidx.appcompat.widget.ThemeUtils\",\"android.support.v7.widget.TintContextWrapper\":\"androidx.appcompat.widget.TintContextWrapper\",\"android.support.v7.widget.TintInfo\":\"androidx.appcompat.widget.TintInfo\",\"android.support.v7.widget.TintResources\":\"androidx.appcompat.widget.TintResources\",\"android.support.v7.widget.TintTypedArray\":\"androidx.appcompat.widget.TintTypedArray\",\"android.support.v7.widget.Toolbar\":\"androidx.appcompat.widget.Toolbar\",\"android.support.v7.widget.ToolbarWidgetWrapper\":\"androidx.appcompat.widget.ToolbarWidgetWrapper\",\"android.support.v7.widget.TooltipCompat\":\"androidx.appcompat.widget.TooltipCompat\",\"android.support.v7.widget.TooltipCompatHandler\":\"androidx.appcompat.widget.TooltipCompatHandler\",\"android.support.v7.widget.TooltipPopup\":\"androidx.appcompat.widget.TooltipPopup\",\"android.support.v7.widget.util.SortedListAdapterCallback\":\"androidx.recyclerview.widget.SortedListAdapterCallback\",\"android.support.v7.widget.VectorEnabledTintResources\":\"androidx.appcompat.widget.VectorEnabledTintResources\",\"android.support.v7.widget.ViewBoundsCheck\":\"androidx.recyclerview.widget.ViewBoundsCheck\",\"android.support.v7.widget.ViewInfoStore\":\"androidx.recyclerview.widget.ViewInfoStore\",\"android.support.v7.widget.ViewStubCompat\":\"androidx.appcompat.widget.ViewStubCompat\",\"android.support.v7.widget.ViewUtils\":\"androidx.appcompat.widget.ViewUtils\",\"android.support.v7.widget.WithHint\":\"androidx.appcompat.widget.WithHint\",\"android.support.wear.activity.ConfirmationActivity\":\"androidx.wear.activity.ConfirmationActivity\",\"android.support.wear.ambient.AmbientDelegate\":\"androidx.wear.ambient.AmbientDelegate\",\"android.support.wear.ambient.AmbientMode\":\"androidx.wear.ambient.AmbientMode\",\"android.support.wear.ambient.AmbientModeSupport\":\"androidx.wear.ambient.AmbientModeSupport\",\"android.support.wear.ambient.SharedLibraryVersion\":\"androidx.wear.ambient.SharedLibraryVersion\",\"android.support.wear.ambient.WearableControllerProvider\":\"androidx.wear.ambient.WearableControllerProvider\",\"android.support.wear.internal.widget.drawer.MultiPagePresenter\":\"androidx.wear.internal.widget.drawer.MultiPagePresenter\",\"android.support.wear.internal.widget.drawer.MultiPageUi\":\"androidx.wear.internal.widget.drawer.MultiPageUi\",\"android.support.wear.internal.widget.drawer.SinglePagePresenter\":\"androidx.wear.internal.widget.drawer.SinglePagePresenter\",\"android.support.wear.internal.widget.drawer.SinglePageUi\":\"androidx.wear.internal.widget.drawer.SinglePageUi\",\"android.support.wear.internal.widget.drawer.WearableNavigationDrawerPresenter\":\"androidx.wear.internal.widget.drawer.WearableNavigationDrawerPresenter\",\"android.support.wear.internal.widget.ResourcesUtil\":\"androidx.wear.internal.widget.ResourcesUtil\",\"android.support.wear.R\":\"androidx.wear.R\",\"android.support.wear.utils.MetadataConstants\":\"androidx.wear.utils.MetadataConstants\",\"android.support.wear.widget.BezierSCurveInterpolator\":\"androidx.wear.widget.BezierSCurveInterpolator\",\"android.support.wear.widget.BoxInsetLayout\":\"androidx.wear.widget.BoxInsetLayout\",\"android.support.wear.widget.CircledImageView\":\"androidx.wear.widget.CircledImageView\",\"android.support.wear.widget.CircularProgressLayout\":\"androidx.wear.widget.CircularProgressLayout\",\"android.support.wear.widget.CircularProgressLayoutController\":\"androidx.wear.widget.CircularProgressLayoutController\",\"android.support.wear.widget.ConfirmationOverlay\":\"androidx.wear.widget.ConfirmationOverlay\",\"android.support.wear.widget.CurvingLayoutCallback\":\"androidx.wear.widget.CurvingLayoutCallback\",\"android.support.wear.widget.drawer.AbsListViewFlingWatcher\":\"androidx.wear.widget.drawer.AbsListViewFlingWatcher\",\"android.support.wear.widget.drawer.FlingWatcherFactory\":\"androidx.wear.widget.drawer.FlingWatcherFactory\",\"android.support.wear.widget.drawer.NestedScrollViewFlingWatcher\":\"androidx.wear.widget.drawer.NestedScrollViewFlingWatcher\",\"android.support.wear.widget.drawer.PageIndicatorView\":\"androidx.wear.widget.drawer.PageIndicatorView\",\"android.support.wear.widget.drawer.RecyclerViewFlingWatcher\":\"androidx.wear.widget.drawer.RecyclerViewFlingWatcher\",\"android.support.wear.widget.drawer.ScrollViewFlingWatcher\":\"androidx.wear.widget.drawer.ScrollViewFlingWatcher\",\"android.support.wear.widget.drawer.WearableActionDrawerMenu\":\"androidx.wear.widget.drawer.WearableActionDrawerMenu\",\"android.support.wear.widget.drawer.WearableActionDrawerView\":\"androidx.wear.widget.drawer.WearableActionDrawerView\",\"android.support.wear.widget.drawer.WearableDrawerController\":\"androidx.wear.widget.drawer.WearableDrawerController\",\"android.support.wear.widget.drawer.WearableDrawerLayout\":\"androidx.wear.widget.drawer.WearableDrawerLayout\",\"android.support.wear.widget.drawer.WearableDrawerView\":\"androidx.wear.widget.drawer.WearableDrawerView\",\"android.support.wear.widget.drawer.WearableNavigationDrawerView\":\"androidx.wear.widget.drawer.WearableNavigationDrawerView\",\"android.support.wear.widget.ProgressDrawable\":\"androidx.wear.widget.ProgressDrawable\",\"android.support.wear.widget.ResourcesUtil\":\"androidx.wear.widget.ResourcesUtil\",\"android.support.wear.widget.RoundedDrawable\":\"androidx.wear.widget.RoundedDrawable\",\"android.support.wear.widget.ScrollManager\":\"androidx.wear.widget.ScrollManager\",\"android.support.wear.widget.SimpleAnimatorListener\":\"androidx.wear.widget.SimpleAnimatorListener\",\"android.support.wear.widget.SwipeDismissFrameLayout\":\"androidx.wear.widget.SwipeDismissFrameLayout\",\"android.support.wear.widget.SwipeDismissLayout\":\"androidx.wear.widget.SwipeDismissLayout\",\"android.support.wear.widget.WearableLinearLayoutManager\":\"androidx.wear.widget.WearableLinearLayoutManager\",\"android.support.wear.widget.WearableRecyclerView\":\"androidx.wear.widget.WearableRecyclerView\"}";

	static Map<String, String> replaceMap = new HashMap<String, String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Support2AndroidX supp = new Support2AndroidX();
		supp.convert();
	}

	private void convert() {
		File projectDir = new File(this.getClass().getResource("/").getPath());
		File assetsFile = new File(projectDir.getParent() + "/src/assets");
		File[] files = assetsFile.listFiles();
		for (File file : files) {
			if (file.getName().equals("androidx-class-mapping.csv")) {
				replaceMap.putAll(readCSV(file.getPath(), true));
			}
		}
		
		try {
			convertDir("D://xxx", "D://yyy");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			convertFile("D://a.java", "D://b.java");
			convertFile("D://a.xml", "D://b.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 如果不想读取csv，可以直接使用这个，或者使用 jsonStr
	 * @return
	 */
	public static Map<String, String> readJSON() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("android.arch.core.executor.AppToolkitTaskExecutor",
				"androidx.arch.core.executor.AppToolkitTaskExecutor");
		map.put("android.arch.core.executor.ArchTaskExecutor", "androidx.arch.core.executor.ArchTaskExecutor");
		map.put("android.arch.core.executor.DefaultTaskExecutor", "androidx.arch.core.executor.DefaultTaskExecutor");
		map.put("android.arch.core.executor.JunitTaskExecutorRule",
				"androidx.arch.core.executor.JunitTaskExecutorRule");
		map.put("android.arch.core.executor.TaskExecutor", "androidx.arch.core.executor.TaskExecutor");
		map.put("android.arch.core.executor.TaskExecutorWithFakeMainThread",
				"androidx.arch.core.executor.TaskExecutorWithFakeMainThread");
		map.put("android.arch.core.executor.testing.CountingTaskExecutorRule",
				"androidx.arch.core.executor.testing.CountingTaskExecutorRule");
		map.put("android.arch.core.executor.testing.InstantTaskExecutorRule",
				"androidx.arch.core.executor.testing.InstantTaskExecutorRule");
		map.put("android.arch.core.internal.FastSafeIterableMap", "androidx.arch.core.internal.FastSafeIterableMap");
		map.put("android.arch.core.internal.SafeIterableMap", "androidx.arch.core.internal.SafeIterableMap");
		map.put("android.arch.core.util.Function", "androidx.arch.core.util.Function");
		map.put("android.arch.lifecycle.AndroidViewModel", "androidx.lifecycle.AndroidViewModel");
		map.put("android.arch.lifecycle.ClassesInfoCache", "androidx.lifecycle.ClassesInfoCache");
		map.put("android.arch.lifecycle.CompositeGeneratedAdaptersObserver",
				"androidx.lifecycle.CompositeGeneratedAdaptersObserver");
		map.put("android.arch.lifecycle.ComputableLiveData", "androidx.lifecycle.ComputableLiveData");
		map.put("android.arch.lifecycle.DefaultLifecycleObserver", "androidx.lifecycle.DefaultLifecycleObserver");
		map.put("android.arch.lifecycle.Elements_extKt", "androidx.lifecycle.Elements_extKt");
		map.put("android.arch.lifecycle.EmptyActivityLifecycleCallbacks",
				"androidx.lifecycle.EmptyActivityLifecycleCallbacks");
		map.put("android.arch.lifecycle.ErrorMessages", "androidx.lifecycle.ErrorMessages");
		map.put("android.arch.lifecycle.FullLifecycleObserver", "androidx.lifecycle.FullLifecycleObserver");
		map.put("android.arch.lifecycle.FullLifecycleObserverAdapter",
				"androidx.lifecycle.FullLifecycleObserverAdapter");
		map.put("android.arch.lifecycle.GeneratedAdapter", "androidx.lifecycle.GeneratedAdapter");
		map.put("android.arch.lifecycle.GenericLifecycleObserver", "androidx.lifecycle.GenericLifecycleObserver");
		map.put("android.arch.lifecycle.HolderFragment", "androidx.lifecycle.HolderFragment");
		map.put("android.arch.lifecycle.Input_collectorKt", "androidx.lifecycle.Input_collectorKt");
		map.put("android.arch.lifecycle.Lifecycle", "androidx.lifecycle.Lifecycle");
		map.put("android.arch.lifecycle.LifecycleDispatcher", "androidx.lifecycle.LifecycleDispatcher");
		map.put("android.arch.lifecycle.LifecycleObserver", "androidx.lifecycle.LifecycleObserver");
		map.put("android.arch.lifecycle.LifecycleOwner", "androidx.lifecycle.LifecycleOwner");
		map.put("android.arch.lifecycle.LifecycleProcessor", "androidx.lifecycle.LifecycleProcessor");
		map.put("android.arch.lifecycle.LifecycleRegistry", "androidx.lifecycle.LifecycleRegistry");
		map.put("android.arch.lifecycle.LifecycleRegistryOwner", "androidx.lifecycle.LifecycleRegistryOwner");
		map.put("android.arch.lifecycle.LifecycleService", "androidx.lifecycle.LifecycleService");
		map.put("android.arch.lifecycle.Lifecycling", "androidx.lifecycle.Lifecycling");
		map.put("android.arch.lifecycle.LiveData", "androidx.lifecycle.LiveData");
		map.put("android.arch.lifecycle.LiveDataReactiveStreams", "androidx.lifecycle.LiveDataReactiveStreams");
		map.put("android.arch.lifecycle.MediatorLiveData", "androidx.lifecycle.MediatorLiveData");
		map.put("android.arch.lifecycle.MethodCallsLogger", "androidx.lifecycle.MethodCallsLogger");
		map.put("android.arch.lifecycle.model.AdapterClass", "androidx.lifecycle.model.AdapterClass");
		map.put("android.arch.lifecycle.model.AdapterClassKt", "androidx.lifecycle.model.AdapterClassKt");
		map.put("android.arch.lifecycle.model.EventMethod", "androidx.lifecycle.model.EventMethod");
		map.put("android.arch.lifecycle.model.EventMethodCall", "androidx.lifecycle.model.EventMethodCall");
		map.put("android.arch.lifecycle.model.InputModel", "androidx.lifecycle.model.InputModel");
		map.put("android.arch.lifecycle.model.LifecycleObserverInfo", "androidx.lifecycle.model.LifecycleObserverInfo");
		map.put("android.arch.lifecycle.MutableLiveData", "androidx.lifecycle.MutableLiveData");
		map.put("android.arch.lifecycle.Observer", "androidx.lifecycle.Observer");
		map.put("android.arch.lifecycle.ObserversCollector", "androidx.lifecycle.ObserversCollector");
		map.put("android.arch.lifecycle.OnLifecycleEvent", "androidx.lifecycle.OnLifecycleEvent");
		map.put("android.arch.lifecycle.ProcessLifecycleOwner", "androidx.lifecycle.ProcessLifecycleOwner");
		map.put("android.arch.lifecycle.ProcessLifecycleOwnerInitializer",
				"androidx.lifecycle.ProcessLifecycleOwnerInitializer");
		map.put("android.arch.lifecycle.ReflectiveGenericLifecycleObserver",
				"androidx.lifecycle.ReflectiveGenericLifecycleObserver");
		map.put("android.arch.lifecycle.ReportFragment", "androidx.lifecycle.ReportFragment");
		map.put("android.arch.lifecycle.ServiceLifecycleDispatcher", "androidx.lifecycle.ServiceLifecycleDispatcher");
		map.put("android.arch.lifecycle.SingleGeneratedAdapterObserver",
				"androidx.lifecycle.SingleGeneratedAdapterObserver");
		map.put("android.arch.lifecycle.TransformationKt", "androidx.lifecycle.TransformationKt");
		map.put("android.arch.lifecycle.Transformations", "androidx.lifecycle.Transformations");
		map.put("android.arch.lifecycle.Validator", "androidx.lifecycle.Validator");
		map.put("android.arch.lifecycle.ViewModel", "androidx.lifecycle.ViewModel");
		map.put("android.arch.lifecycle.ViewModelProvider", "androidx.lifecycle.ViewModelProvider");
		map.put("android.arch.lifecycle.ViewModelProviders", "androidx.lifecycle.ViewModelProviders");
		map.put("android.arch.lifecycle.ViewModelStore", "androidx.lifecycle.ViewModelStore");
		map.put("android.arch.lifecycle.ViewModelStoreOwner", "androidx.lifecycle.ViewModelStoreOwner");
		map.put("android.arch.lifecycle.ViewModelStores", "androidx.lifecycle.ViewModelStores");
		map.put("android.arch.lifecycle.WriterKt", "androidx.lifecycle.WriterKt");
		map.put("android.arch.paging.AsyncPagedListDiffer", "androidx.paging.AsyncPagedListDiffer");
		map.put("android.arch.paging.ContiguousDataSource", "androidx.paging.ContiguousDataSource");
		map.put("android.arch.paging.ContiguousPagedList", "androidx.paging.ContiguousPagedList");
		map.put("android.arch.paging.DataSource", "androidx.paging.DataSource");
		map.put("android.arch.paging.ItemKeyedDataSource", "androidx.paging.ItemKeyedDataSource");
		map.put("android.arch.paging.ListDataSource", "androidx.paging.ListDataSource");
		map.put("android.arch.paging.LivePagedListBuilder", "androidx.paging.LivePagedListBuilder");
		map.put("android.arch.paging.LivePagedListProvider", "androidx.paging.LivePagedListProvider");
		map.put("android.arch.paging.PagedList", "androidx.paging.PagedList");
		map.put("android.arch.paging.PagedListAdapter", "androidx.paging.PagedListAdapter");
		map.put("android.arch.paging.PagedStorage", "androidx.paging.PagedStorage");
		map.put("android.arch.paging.PagedStorageDiffHelper", "androidx.paging.PagedStorageDiffHelper");
		map.put("android.arch.paging.PageKeyedDataSource", "androidx.paging.PageKeyedDataSource");
		map.put("android.arch.paging.PageResult", "androidx.paging.PageResult");
		map.put("android.arch.paging.PositionalDataSource", "androidx.paging.PositionalDataSource");
		map.put("android.arch.paging.RxPagedListBuilder", "androidx.paging.RxPagedListBuilder");
		map.put("android.arch.paging.SnapshotPagedList", "androidx.paging.SnapshotPagedList");
		map.put("android.arch.paging.TiledDataSource", "androidx.paging.TiledDataSource");
		map.put("android.arch.paging.TiledPagedList", "androidx.paging.TiledPagedList");
		map.put("android.arch.paging.WrapperItemKeyedDataSource", "androidx.paging.WrapperItemKeyedDataSource");
		map.put("android.arch.paging.WrapperPageKeyedDataSource", "androidx.paging.WrapperPageKeyedDataSource");
		map.put("android.arch.paging.WrapperPositionalDataSource", "androidx.paging.WrapperPositionalDataSource");
		map.put("android.arch.persistence.db.framework.FrameworkSQLiteDatabase",
				"androidx.sqlite.db.framework.FrameworkSQLiteDatabase");
		map.put("android.arch.persistence.db.framework.FrameworkSQLiteOpenHelper",
				"androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper");
		map.put("android.arch.persistence.db.framework.FrameworkSQLiteOpenHelperFactory",
				"androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory");
		map.put("android.arch.persistence.db.framework.FrameworkSQLiteProgram",
				"androidx.sqlite.db.framework.FrameworkSQLiteProgram");
		map.put("android.arch.persistence.db.framework.FrameworkSQLiteStatement",
				"androidx.sqlite.db.framework.FrameworkSQLiteStatement");
		map.put("android.arch.persistence.db.SimpleSQLiteQuery", "androidx.sqlite.db.SimpleSQLiteQuery");
		map.put("android.arch.persistence.db.SupportSQLiteDatabase", "androidx.sqlite.db.SupportSQLiteDatabase");
		map.put("android.arch.persistence.db.SupportSQLiteOpenHelper", "androidx.sqlite.db.SupportSQLiteOpenHelper");
		map.put("android.arch.persistence.db.SupportSQLiteProgram", "androidx.sqlite.db.SupportSQLiteProgram");
		map.put("android.arch.persistence.db.SupportSQLiteQuery", "androidx.sqlite.db.SupportSQLiteQuery");
		map.put("android.arch.persistence.db.SupportSQLiteQueryBuilder",
				"androidx.sqlite.db.SupportSQLiteQueryBuilder");
		map.put("android.arch.persistence.db.SupportSQLiteStatement", "androidx.sqlite.db.SupportSQLiteStatement");
		map.put("android.arch.persistence.room.ColumnInfo", "androidx.room.ColumnInfo");
		map.put("android.arch.persistence.room.Dao", "androidx.room.Dao");
		map.put("android.arch.persistence.room.Database", "androidx.room.Database");
		map.put("android.arch.persistence.room.DatabaseConfiguration", "androidx.room.DatabaseConfiguration");
		map.put("android.arch.persistence.room.Delete", "androidx.room.Delete");
		map.put("android.arch.persistence.room.Embedded", "androidx.room.Embedded");
		map.put("android.arch.persistence.room.EmptyResultSetException", "androidx.room.EmptyResultSetException");
		map.put("android.arch.persistence.room.Entity", "androidx.room.Entity");
		map.put("android.arch.persistence.room.EntityDeletionOrUpdateAdapter",
				"androidx.room.EntityDeletionOrUpdateAdapter");
		map.put("android.arch.persistence.room.EntityInsertionAdapter", "androidx.room.EntityInsertionAdapter");
		map.put("android.arch.persistence.room.ext.AndroidTypeNames", "androidx.room.ext.AndroidTypeNames");
		map.put("android.arch.persistence.room.ext.ArchTypeNames", "androidx.room.ext.ArchTypeNames");
		map.put("android.arch.persistence.room.ext.CommonTypeNames", "androidx.room.ext.CommonTypeNames");
		map.put("android.arch.persistence.room.ext.Element_extKt", "androidx.room.ext.Element_extKt");
		map.put("android.arch.persistence.room.ext.GuavaBaseTypeNames", "androidx.room.ext.GuavaBaseTypeNames");
		map.put("android.arch.persistence.room.ext.GuavaUtilConcurrentTypeNames",
				"androidx.room.ext.GuavaUtilConcurrentTypeNames");
		map.put("android.arch.persistence.room.ext.Javapoet_extKt", "androidx.room.ext.Javapoet_extKt");
		map.put("android.arch.persistence.room.ext.KotlinMetadataProcessor",
				"androidx.room.ext.KotlinMetadataProcessor");
		map.put("android.arch.persistence.room.ext.LifecyclesTypeNames", "androidx.room.ext.LifecyclesTypeNames");
		map.put("android.arch.persistence.room.ext.PagingTypeNames", "androidx.room.ext.PagingTypeNames");
		map.put("android.arch.persistence.room.ext.ReactiveStreamsTypeNames",
				"androidx.room.ext.ReactiveStreamsTypeNames");
		map.put("android.arch.persistence.room.ext.RoomGuavaTypeNames", "androidx.room.ext.RoomGuavaTypeNames");
		map.put("android.arch.persistence.room.ext.RoomRxJava2TypeNames", "androidx.room.ext.RoomRxJava2TypeNames");
		map.put("android.arch.persistence.room.ext.RoomTypeNames", "androidx.room.ext.RoomTypeNames");
		map.put("android.arch.persistence.room.ext.RxJava2TypeNames", "androidx.room.ext.RxJava2TypeNames");
		map.put("android.arch.persistence.room.ext.SupportDbTypeNames", "androidx.room.ext.SupportDbTypeNames");
		map.put("android.arch.persistence.room.ForeignKey", "androidx.room.ForeignKey");
		map.put("android.arch.persistence.room.guava.GuavaRoom", "androidx.room.guava.GuavaRoom");
		map.put("android.arch.persistence.room.Ignore", "androidx.room.Ignore");
		map.put("android.arch.persistence.room.Index", "androidx.room.Index");
		map.put("android.arch.persistence.room.Insert", "androidx.room.Insert");
		map.put("android.arch.persistence.room.InvalidationTracker", "androidx.room.InvalidationTracker");
		map.put("android.arch.persistence.room.log.RLog", "androidx.room.log.RLog");
		map.put("android.arch.persistence.room.migration.bundle.BundleUtil",
				"androidx.room.migration.bundle.BundleUtil");
		map.put("android.arch.persistence.room.migration.bundle.DatabaseBundle",
				"androidx.room.migration.bundle.DatabaseBundle");
		map.put("android.arch.persistence.room.migration.bundle.EntityBundle",
				"androidx.room.migration.bundle.EntityBundle");
		map.put("android.arch.persistence.room.migration.bundle.FieldBundle",
				"androidx.room.migration.bundle.FieldBundle");
		map.put("android.arch.persistence.room.migration.bundle.ForeignKeyBundle",
				"androidx.room.migration.bundle.ForeignKeyBundle");
		map.put("android.arch.persistence.room.migration.bundle.IndexBundle",
				"androidx.room.migration.bundle.IndexBundle");
		map.put("android.arch.persistence.room.migration.bundle.PrimaryKeyBundle",
				"androidx.room.migration.bundle.PrimaryKeyBundle");
		map.put("android.arch.persistence.room.migration.bundle.SchemaBundle",
				"androidx.room.migration.bundle.SchemaBundle");
		map.put("android.arch.persistence.room.migration.bundle.SchemaEquality",
				"androidx.room.migration.bundle.SchemaEquality");
		map.put("android.arch.persistence.room.migration.bundle.SchemaEqualityUtil",
				"androidx.room.migration.bundle.SchemaEqualityUtil");
		map.put("android.arch.persistence.room.migration.Migration", "androidx.room.migration.Migration");
		map.put("android.arch.persistence.room.OnConflictStrategy", "androidx.room.OnConflictStrategy");
		map.put("android.arch.persistence.room.paging.LimitOffsetDataSource",
				"androidx.room.paging.LimitOffsetDataSource");
		map.put("android.arch.persistence.room.parser.Collate", "androidx.room.parser.Collate");
		map.put("android.arch.persistence.room.parser.ParsedQuery", "androidx.room.parser.ParsedQuery");
		map.put("android.arch.persistence.room.parser.ParserErrors", "androidx.room.parser.ParserErrors");
		map.put("android.arch.persistence.room.parser.QueryType", "androidx.room.parser.QueryType");
		map.put("android.arch.persistence.room.parser.QueryVisitor", "androidx.room.parser.QueryVisitor");
		map.put("android.arch.persistence.room.parser.Section", "androidx.room.parser.Section");
		map.put("android.arch.persistence.room.parser.SectionType", "androidx.room.parser.SectionType");
		map.put("android.arch.persistence.room.parser.SQLiteBaseListener", "androidx.room.parser.SQLiteBaseListener");
		map.put("android.arch.persistence.room.parser.SQLiteBaseVisitor", "androidx.room.parser.SQLiteBaseVisitor");
		map.put("android.arch.persistence.room.parser.SQLiteLexer", "androidx.room.parser.SQLiteLexer");
		map.put("android.arch.persistence.room.parser.SQLiteListener", "androidx.room.parser.SQLiteListener");
		map.put("android.arch.persistence.room.parser.SQLiteParser", "androidx.room.parser.SQLiteParser");
		map.put("android.arch.persistence.room.parser.SQLiteVisitor", "androidx.room.parser.SQLiteVisitor");
		map.put("android.arch.persistence.room.parser.SqlParser", "androidx.room.parser.SqlParser");
		map.put("android.arch.persistence.room.parser.SQLTypeAffinity", "androidx.room.parser.SQLTypeAffinity");
		map.put("android.arch.persistence.room.parser.Table", "androidx.room.parser.Table");
		map.put("android.arch.persistence.room.preconditions.Checks", "androidx.room.preconditions.Checks");
		map.put("android.arch.persistence.room.PrimaryKey", "androidx.room.PrimaryKey");
		map.put("android.arch.persistence.room.processor.cache.Cache", "androidx.room.processor.cache.Cache");
		map.put("android.arch.persistence.room.processor.Context", "androidx.room.processor.Context");
		map.put("android.arch.persistence.room.processor.CustomConverterProcessor",
				"androidx.room.processor.CustomConverterProcessor");
		map.put("android.arch.persistence.room.processor.DaoProcessor", "androidx.room.processor.DaoProcessor");
		map.put("android.arch.persistence.room.processor.DatabaseProcessor",
				"androidx.room.processor.DatabaseProcessor");
		map.put("android.arch.persistence.room.processor.DeletionMethodProcessor",
				"androidx.room.processor.DeletionMethodProcessor");
		map.put("android.arch.persistence.room.processor.EntityProcessor", "androidx.room.processor.EntityProcessor");
		map.put("android.arch.persistence.room.processor.FieldProcessor", "androidx.room.processor.FieldProcessor");
		map.put("android.arch.persistence.room.processor.InsertionMethodProcessor",
				"androidx.room.processor.InsertionMethodProcessor");
		map.put("android.arch.persistence.room.processor.OnConflictProcessor",
				"androidx.room.processor.OnConflictProcessor");
		map.put("android.arch.persistence.room.processor.PojoMethodProcessor",
				"androidx.room.processor.PojoMethodProcessor");
		map.put("android.arch.persistence.room.processor.PojoProcessor", "androidx.room.processor.PojoProcessor");
		map.put("android.arch.persistence.room.processor.ProcessorErrors", "androidx.room.processor.ProcessorErrors");
		map.put("android.arch.persistence.room.processor.QueryMethodProcessor",
				"androidx.room.processor.QueryMethodProcessor");
		map.put("android.arch.persistence.room.processor.QueryParameterProcessor",
				"androidx.room.processor.QueryParameterProcessor");
		map.put("android.arch.persistence.room.processor.RawQueryMethodProcessor",
				"androidx.room.processor.RawQueryMethodProcessor");
		map.put("android.arch.persistence.room.processor.ShortcutMethodProcessor",
				"androidx.room.processor.ShortcutMethodProcessor");
		map.put("android.arch.persistence.room.processor.ShortcutParameterProcessor",
				"androidx.room.processor.ShortcutParameterProcessor");
		map.put("android.arch.persistence.room.processor.SuppressWarningProcessor",
				"androidx.room.processor.SuppressWarningProcessor");
		map.put("android.arch.persistence.room.processor.TransactionMethodProcessor",
				"androidx.room.processor.TransactionMethodProcessor");
		map.put("android.arch.persistence.room.processor.UpdateMethodProcessor",
				"androidx.room.processor.UpdateMethodProcessor");
		map.put("android.arch.persistence.room.Query", "androidx.room.Query");
		map.put("android.arch.persistence.room.RawQuery", "androidx.room.RawQuery");
		map.put("android.arch.persistence.room.Relation", "androidx.room.Relation");
		map.put("android.arch.persistence.room.Room", "androidx.room.Room");
		map.put("android.arch.persistence.room.RoomDatabase", "androidx.room.RoomDatabase");
		map.put("android.arch.persistence.room.RoomMasterTable", "androidx.room.RoomMasterTable");
		map.put("android.arch.persistence.room.RoomOpenHelper", "androidx.room.RoomOpenHelper");
		map.put("android.arch.persistence.room.RoomProcessor", "androidx.room.RoomProcessor");
		map.put("android.arch.persistence.room.RoomSQLiteQuery", "androidx.room.RoomSQLiteQuery");
		map.put("android.arch.persistence.room.RoomWarnings", "androidx.room.RoomWarnings");
		map.put("android.arch.persistence.room.RxRoom", "androidx.room.RxRoom");
		map.put("android.arch.persistence.room.SharedSQLiteStatement", "androidx.room.SharedSQLiteStatement");
		map.put("android.arch.persistence.room.SkipQueryVerification", "androidx.room.SkipQueryVerification");
		map.put("android.arch.persistence.room.solver.binderprovider.CursorQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.CursorQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.DataSourceFactoryQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.DataSourceFactoryQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.DataSourceQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.DataSourceQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.FlowableQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.FlowableQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.GuavaListenableFutureQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.GuavaListenableFutureQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.InstantQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.InstantQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.LiveDataQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.LiveDataQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.RxCallableQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.RxCallableQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.RxMaybeQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.RxMaybeQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.binderprovider.RxSingleQueryResultBinderProvider",
				"androidx.room.solver.binderprovider.RxSingleQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.CodeGenScope", "androidx.room.solver.CodeGenScope");
		map.put("android.arch.persistence.room.solver.ObservableQueryResultBinderProvider",
				"androidx.room.solver.ObservableQueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.query.parameter.ArrayQueryParameterAdapter",
				"androidx.room.solver.query.parameter.ArrayQueryParameterAdapter");
		map.put("android.arch.persistence.room.solver.query.parameter.BasicQueryParameterAdapter",
				"androidx.room.solver.query.parameter.BasicQueryParameterAdapter");
		map.put("android.arch.persistence.room.solver.query.parameter.CollectionQueryParameterAdapter",
				"androidx.room.solver.query.parameter.CollectionQueryParameterAdapter");
		map.put("android.arch.persistence.room.solver.query.parameter.QueryParameterAdapter",
				"androidx.room.solver.query.parameter.QueryParameterAdapter");
		map.put("android.arch.persistence.room.solver.query.result.ArrayQueryResultAdapter",
				"androidx.room.solver.query.result.ArrayQueryResultAdapter");
		map.put("android.arch.persistence.room.solver.query.result.BaseObservableQueryResultBinder",
				"androidx.room.solver.query.result.BaseObservableQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.CursorQueryResultBinder",
				"androidx.room.solver.query.result.CursorQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.DataSourceFactoryQueryResultBinder",
				"androidx.room.solver.query.result.DataSourceFactoryQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.EntityRowAdapter",
				"androidx.room.solver.query.result.EntityRowAdapter");
		map.put("android.arch.persistence.room.solver.query.result.FlowableQueryResultBinder",
				"androidx.room.solver.query.result.FlowableQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.GuavaListenableFutureQueryResultBinder",
				"androidx.room.solver.query.result.GuavaListenableFutureQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.GuavaOptionalQueryResultAdapter",
				"androidx.room.solver.query.result.GuavaOptionalQueryResultAdapter");
		map.put("android.arch.persistence.room.solver.query.result.InstantQueryResultBinder",
				"androidx.room.solver.query.result.InstantQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.ListQueryResultAdapter",
				"androidx.room.solver.query.result.ListQueryResultAdapter");
		map.put("android.arch.persistence.room.solver.query.result.LiveDataQueryResultBinder",
				"androidx.room.solver.query.result.LiveDataQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.OptionalQueryResultAdapter",
				"androidx.room.solver.query.result.OptionalQueryResultAdapter");
		map.put("android.arch.persistence.room.solver.query.result.PojoRowAdapter",
				"androidx.room.solver.query.result.PojoRowAdapter");
		map.put("android.arch.persistence.room.solver.query.result.PositionalDataSourceQueryResultBinder",
				"androidx.room.solver.query.result.PositionalDataSourceQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.QueryResultAdapter",
				"androidx.room.solver.query.result.QueryResultAdapter");
		map.put("android.arch.persistence.room.solver.query.result.QueryResultBinder",
				"androidx.room.solver.query.result.QueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.RowAdapter",
				"androidx.room.solver.query.result.RowAdapter");
		map.put("android.arch.persistence.room.solver.query.result.RxCallableQueryResultBinder",
				"androidx.room.solver.query.result.RxCallableQueryResultBinder");
		map.put("android.arch.persistence.room.solver.query.result.SingleColumnRowAdapter",
				"androidx.room.solver.query.result.SingleColumnRowAdapter");
		map.put("android.arch.persistence.room.solver.query.result.SingleEntityQueryResultAdapter",
				"androidx.room.solver.query.result.SingleEntityQueryResultAdapter");
		map.put("android.arch.persistence.room.solver.query.result.TransactionWrapper",
				"androidx.room.solver.query.result.TransactionWrapper");
		map.put("android.arch.persistence.room.solver.query.result.TransactionWrapperKt",
				"androidx.room.solver.query.result.TransactionWrapperKt");
		map.put("android.arch.persistence.room.solver.QueryResultBinderProvider",
				"androidx.room.solver.QueryResultBinderProvider");
		map.put("android.arch.persistence.room.solver.TypeAdapterStore", "androidx.room.solver.TypeAdapterStore");
		map.put("android.arch.persistence.room.solver.types.BoxedBooleanToBoxedIntConverter",
				"androidx.room.solver.types.BoxedBooleanToBoxedIntConverter");
		map.put("android.arch.persistence.room.solver.types.BoxedPrimitiveColumnTypeAdapter",
				"androidx.room.solver.types.BoxedPrimitiveColumnTypeAdapter");
		map.put("android.arch.persistence.room.solver.types.ByteArrayColumnTypeAdapter",
				"androidx.room.solver.types.ByteArrayColumnTypeAdapter");
		map.put("android.arch.persistence.room.solver.types.ColumnTypeAdapter",
				"androidx.room.solver.types.ColumnTypeAdapter");
		map.put("android.arch.persistence.room.solver.types.CompositeAdapter",
				"androidx.room.solver.types.CompositeAdapter");
		map.put("android.arch.persistence.room.solver.types.CompositeTypeConverter",
				"androidx.room.solver.types.CompositeTypeConverter");
		map.put("android.arch.persistence.room.solver.types.CursorValueReader",
				"androidx.room.solver.types.CursorValueReader");
		map.put("android.arch.persistence.room.solver.types.CustomTypeConverterWrapper",
				"androidx.room.solver.types.CustomTypeConverterWrapper");
		map.put("android.arch.persistence.room.solver.types.NoOpConverter", "androidx.room.solver.types.NoOpConverter");
		map.put("android.arch.persistence.room.solver.types.PrimitiveBooleanToIntConverter",
				"androidx.room.solver.types.PrimitiveBooleanToIntConverter");
		map.put("android.arch.persistence.room.solver.types.PrimitiveColumnTypeAdapter",
				"androidx.room.solver.types.PrimitiveColumnTypeAdapter");
		map.put("android.arch.persistence.room.solver.types.StatementValueBinder",
				"androidx.room.solver.types.StatementValueBinder");
		map.put("android.arch.persistence.room.solver.types.StringColumnTypeAdapter",
				"androidx.room.solver.types.StringColumnTypeAdapter");
		map.put("android.arch.persistence.room.solver.types.TypeConverter", "androidx.room.solver.types.TypeConverter");
		map.put("android.arch.persistence.room.testing.MigrationTestHelper",
				"androidx.room.testing.MigrationTestHelper");
		map.put("android.arch.persistence.room.Transaction", "androidx.room.Transaction");
		map.put("android.arch.persistence.room.TypeConverter", "androidx.room.TypeConverter");
		map.put("android.arch.persistence.room.TypeConverters", "androidx.room.TypeConverters");
		map.put("android.arch.persistence.room.Update", "androidx.room.Update");
		map.put("android.arch.persistence.room.util.StringUtil", "androidx.room.util.StringUtil");
		map.put("android.arch.persistence.room.util.TableInfo", "androidx.room.util.TableInfo");
		map.put("android.arch.persistence.room.verifier.ColumnInfo", "androidx.room.verifier.ColumnInfo");
		map.put("android.arch.persistence.room.verifier.DatabaseVerificationErrors",
				"androidx.room.verifier.DatabaseVerificationErrors");
		map.put("android.arch.persistence.room.verifier.DatabaseVerifier", "androidx.room.verifier.DatabaseVerifier");
		map.put("android.arch.persistence.room.verifier.QueryResultInfo", "androidx.room.verifier.QueryResultInfo");
		map.put("android.arch.persistence.room.vo.CallType", "androidx.room.vo.CallType");
		map.put("android.arch.persistence.room.vo.Constructor", "androidx.room.vo.Constructor");
		map.put("android.arch.persistence.room.vo.CustomTypeConverter", "androidx.room.vo.CustomTypeConverter");
		map.put("android.arch.persistence.room.vo.Dao", "androidx.room.vo.Dao");
		map.put("android.arch.persistence.room.vo.DaoMethod", "androidx.room.vo.DaoMethod");
		map.put("android.arch.persistence.room.vo.Database", "androidx.room.vo.Database");
		map.put("android.arch.persistence.room.vo.DeletionMethod", "androidx.room.vo.DeletionMethod");
		map.put("android.arch.persistence.room.vo.EmbeddedField", "androidx.room.vo.EmbeddedField");
		map.put("android.arch.persistence.room.vo.Entity", "androidx.room.vo.Entity");
		map.put("android.arch.persistence.room.vo.Field", "androidx.room.vo.Field");
		map.put("android.arch.persistence.room.vo.FieldGetter", "androidx.room.vo.FieldGetter");
		map.put("android.arch.persistence.room.vo.FieldSetter", "androidx.room.vo.FieldSetter");
		map.put("android.arch.persistence.room.vo.FieldWithIndex", "androidx.room.vo.FieldWithIndex");
		map.put("android.arch.persistence.room.vo.ForeignKey", "androidx.room.vo.ForeignKey");
		map.put("android.arch.persistence.room.vo.ForeignKeyAction", "androidx.room.vo.ForeignKeyAction");
		map.put("android.arch.persistence.room.vo.HasSchemaIdentity", "androidx.room.vo.HasSchemaIdentity");
		map.put("android.arch.persistence.room.vo.Index", "androidx.room.vo.Index");
		map.put("android.arch.persistence.room.vo.InsertionMethod", "androidx.room.vo.InsertionMethod");
		map.put("android.arch.persistence.room.vo.Pojo", "androidx.room.vo.Pojo");
		map.put("android.arch.persistence.room.vo.PojoMethod", "androidx.room.vo.PojoMethod");
		map.put("android.arch.persistence.room.vo.PrimaryKey", "androidx.room.vo.PrimaryKey");
		map.put("android.arch.persistence.room.vo.QueryMethod", "androidx.room.vo.QueryMethod");
		map.put("android.arch.persistence.room.vo.QueryParameter", "androidx.room.vo.QueryParameter");
		map.put("android.arch.persistence.room.vo.RawQueryMethod", "androidx.room.vo.RawQueryMethod");
		map.put("android.arch.persistence.room.vo.Relation", "androidx.room.vo.Relation");
		map.put("android.arch.persistence.room.vo.RelationCollector", "androidx.room.vo.RelationCollector");
		map.put("android.arch.persistence.room.vo.SchemaIdentityKey", "androidx.room.vo.SchemaIdentityKey");
		map.put("android.arch.persistence.room.vo.ShortcutMethod", "androidx.room.vo.ShortcutMethod");
		map.put("android.arch.persistence.room.vo.ShortcutQueryParameter", "androidx.room.vo.ShortcutQueryParameter");
		map.put("android.arch.persistence.room.vo.TransactionMethod", "androidx.room.vo.TransactionMethod");
		map.put("android.arch.persistence.room.vo.UpdateMethod", "androidx.room.vo.UpdateMethod");
		map.put("android.arch.persistence.room.vo.Warning", "androidx.room.vo.Warning");
		map.put("android.arch.persistence.room.writer.ClassWriter", "androidx.room.writer.ClassWriter");
		map.put("android.arch.persistence.room.writer.DaoWriter", "androidx.room.writer.DaoWriter");
		map.put("android.arch.persistence.room.writer.DatabaseWriter", "androidx.room.writer.DatabaseWriter");
		map.put("android.arch.persistence.room.writer.EntityCursorConverterWriter",
				"androidx.room.writer.EntityCursorConverterWriter");
		map.put("android.arch.persistence.room.writer.EntityDeleteComparator",
				"androidx.room.writer.EntityDeleteComparator");
		map.put("android.arch.persistence.room.writer.EntityDeletionAdapterWriter",
				"androidx.room.writer.EntityDeletionAdapterWriter");
		map.put("android.arch.persistence.room.writer.EntityInsertionAdapterWriter",
				"androidx.room.writer.EntityInsertionAdapterWriter");
		map.put("android.arch.persistence.room.writer.EntityUpdateAdapterWriter",
				"androidx.room.writer.EntityUpdateAdapterWriter");
		map.put("android.arch.persistence.room.writer.FieldReadWriteWriter",
				"androidx.room.writer.FieldReadWriteWriter");
		map.put("android.arch.persistence.room.writer.PreparedStatementWriter",
				"androidx.room.writer.PreparedStatementWriter");
		map.put("android.arch.persistence.room.writer.QueryWriter", "androidx.room.writer.QueryWriter");
		map.put("android.arch.persistence.room.writer.RelationCollectorMethodWriter",
				"androidx.room.writer.RelationCollectorMethodWriter");
		map.put("android.arch.persistence.room.writer.SQLiteOpenHelperWriter",
				"androidx.room.writer.SQLiteOpenHelperWriter");
		map.put("android.arch.persistence.room.writer.TableInfoValidationWriter",
				"androidx.room.writer.TableInfoValidationWriter");
		map.put("android.databinding.adapters.AbsListViewBindingAdapter",
				"androidx.databinding.adapters.AbsListViewBindingAdapter");
		map.put("android.databinding.adapters.AbsSeekBarBindingAdapter",
				"androidx.databinding.adapters.AbsSeekBarBindingAdapter");
		map.put("android.databinding.adapters.AbsSpinnerBindingAdapter",
				"androidx.databinding.adapters.AbsSpinnerBindingAdapter");
		map.put("android.databinding.adapters.ActionMenuViewBindingAdapter",
				"androidx.databinding.adapters.ActionMenuViewBindingAdapter");
		map.put("android.databinding.adapters.AdapterViewBindingAdapter",
				"androidx.databinding.adapters.AdapterViewBindingAdapter");
		map.put("android.databinding.adapters.AutoCompleteTextViewBindingAdapter",
				"androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter");
		map.put("android.databinding.adapters.CalendarViewBindingAdapter",
				"androidx.databinding.adapters.CalendarViewBindingAdapter");
		map.put("android.databinding.adapters.CardViewBindingAdapter",
				"androidx.databinding.adapters.CardViewBindingAdapter");
		map.put("android.databinding.adapters.CheckedTextViewBindingAdapter",
				"androidx.databinding.adapters.CheckedTextViewBindingAdapter");
		map.put("android.databinding.adapters.ChronometerBindingAdapter",
				"androidx.databinding.adapters.ChronometerBindingAdapter");
		map.put("android.databinding.adapters.CompoundButtonBindingAdapter",
				"androidx.databinding.adapters.CompoundButtonBindingAdapter");
		map.put("android.databinding.adapters.Converters", "androidx.databinding.adapters.Converters");
		map.put("android.databinding.adapters.DatePickerBindingAdapter",
				"androidx.databinding.adapters.DatePickerBindingAdapter");
		map.put("android.databinding.adapters.ExpandableListViewBindingAdapter",
				"androidx.databinding.adapters.ExpandableListViewBindingAdapter");
		map.put("android.databinding.adapters.FrameLayoutBindingAdapter",
				"androidx.databinding.adapters.FrameLayoutBindingAdapter");
		map.put("android.databinding.adapters.ImageViewBindingAdapter",
				"androidx.databinding.adapters.ImageViewBindingAdapter");
		map.put("android.databinding.adapters.LinearLayoutBindingAdapter",
				"androidx.databinding.adapters.LinearLayoutBindingAdapter");
		map.put("android.databinding.adapters.ListenerUtil", "androidx.databinding.adapters.ListenerUtil");
		map.put("android.databinding.adapters.NumberPickerBindingAdapter",
				"androidx.databinding.adapters.NumberPickerBindingAdapter");
		map.put("android.databinding.adapters.ObservableListAdapter",
				"androidx.databinding.adapters.ObservableListAdapter");
		map.put("android.databinding.adapters.ProgressBarBindingAdapter",
				"androidx.databinding.adapters.ProgressBarBindingAdapter");
		map.put("android.databinding.adapters.RadioGroupBindingAdapter",
				"androidx.databinding.adapters.RadioGroupBindingAdapter");
		map.put("android.databinding.adapters.RatingBarBindingAdapter",
				"androidx.databinding.adapters.RatingBarBindingAdapter");
		map.put("android.databinding.adapters.SearchViewBindingAdapter",
				"androidx.databinding.adapters.SearchViewBindingAdapter");
		map.put("android.databinding.adapters.SeekBarBindingAdapter",
				"androidx.databinding.adapters.SeekBarBindingAdapter");
		map.put("android.databinding.adapters.SpinnerBindingAdapter",
				"androidx.databinding.adapters.SpinnerBindingAdapter");
		map.put("android.databinding.adapters.SwitchBindingAdapter",
				"androidx.databinding.adapters.SwitchBindingAdapter");
		map.put("android.databinding.adapters.SwitchCompatBindingAdapter",
				"androidx.databinding.adapters.SwitchCompatBindingAdapter");
		map.put("android.databinding.adapters.TabHostBindingAdapter",
				"androidx.databinding.adapters.TabHostBindingAdapter");
		map.put("android.databinding.adapters.TableLayoutBindingAdapter",
				"androidx.databinding.adapters.TableLayoutBindingAdapter");
		map.put("android.databinding.adapters.TabWidgetBindingAdapter",
				"androidx.databinding.adapters.TabWidgetBindingAdapter");
		map.put("android.databinding.adapters.TextViewBindingAdapter",
				"androidx.databinding.adapters.TextViewBindingAdapter");
		map.put("android.databinding.adapters.TimePickerBindingAdapter",
				"androidx.databinding.adapters.TimePickerBindingAdapter");
		map.put("android.databinding.adapters.ToolbarBindingAdapter",
				"androidx.databinding.adapters.ToolbarBindingAdapter");
		map.put("android.databinding.adapters.VideoViewBindingAdapter",
				"androidx.databinding.adapters.VideoViewBindingAdapter");
		map.put("android.databinding.adapters.ViewBindingAdapter", "androidx.databinding.adapters.ViewBindingAdapter");
		map.put("android.databinding.adapters.ViewGroupBindingAdapter",
				"androidx.databinding.adapters.ViewGroupBindingAdapter");
		map.put("android.databinding.adapters.ViewStubBindingAdapter",
				"androidx.databinding.adapters.ViewStubBindingAdapter");
		map.put("android.databinding.adapters.ZoomControlsBindingAdapter",
				"androidx.databinding.adapters.ZoomControlsBindingAdapter");
		map.put("android.databinding.BaseObservable", "androidx.databinding.BaseObservable");
		map.put("android.databinding.BaseObservableField", "androidx.databinding.BaseObservableField");
		map.put("android.databinding.Bindable", "androidx.databinding.Bindable");
		map.put("android.databinding.BindingAdapter", "androidx.databinding.BindingAdapter");
		map.put("android.databinding.BindingBuildInfo", "androidx.databinding.BindingBuildInfo");
		map.put("android.databinding.BindingConversion", "androidx.databinding.BindingConversion");
		map.put("android.databinding.BindingMethod", "androidx.databinding.BindingMethod");
		map.put("android.databinding.BindingMethods", "androidx.databinding.BindingMethods");
		map.put("android.databinding.CallbackRegistry", "androidx.databinding.CallbackRegistry");
		map.put("android.databinding.DataBinderMapper", "androidx.databinding.DataBinderMapper");
		map.put("android.databinding.DataBinderMapperImpl", "androidx.databinding.DataBinderMapperImpl");
		map.put("android.databinding.DataBindingComponent", "androidx.databinding.DataBindingComponent");
		map.put("android.databinding.DataBindingUtil", "androidx.databinding.DataBindingUtil");
		map.put("android.databinding.InverseBindingAdapter", "androidx.databinding.InverseBindingAdapter");
		map.put("android.databinding.InverseBindingListener", "androidx.databinding.InverseBindingListener");
		map.put("android.databinding.InverseBindingMethod", "androidx.databinding.InverseBindingMethod");
		map.put("android.databinding.InverseBindingMethods", "androidx.databinding.InverseBindingMethods");
		map.put("android.databinding.InverseMethod", "androidx.databinding.InverseMethod");
		map.put("android.databinding.ListChangeRegistry", "androidx.databinding.ListChangeRegistry");
		map.put("android.databinding.MapChangeRegistry", "androidx.databinding.MapChangeRegistry");
		map.put("android.databinding.MergedDataBinderMapper", "androidx.databinding.MergedDataBinderMapper");
		map.put("android.databinding.Observable", "androidx.databinding.Observable");
		map.put("android.databinding.ObservableArrayList", "androidx.databinding.ObservableArrayList");
		map.put("android.databinding.ObservableArrayMap", "androidx.databinding.ObservableArrayMap");
		map.put("android.databinding.ObservableBoolean", "androidx.databinding.ObservableBoolean");
		map.put("android.databinding.ObservableByte", "androidx.databinding.ObservableByte");
		map.put("android.databinding.ObservableChar", "androidx.databinding.ObservableChar");
		map.put("android.databinding.ObservableDouble", "androidx.databinding.ObservableDouble");
		map.put("android.databinding.ObservableField", "androidx.databinding.ObservableField");
		map.put("android.databinding.ObservableFloat", "androidx.databinding.ObservableFloat");
		map.put("android.databinding.ObservableInt", "androidx.databinding.ObservableInt");
		map.put("android.databinding.ObservableList", "androidx.databinding.ObservableList");
		map.put("android.databinding.ObservableLong", "androidx.databinding.ObservableLong");
		map.put("android.databinding.ObservableMap", "androidx.databinding.ObservableMap");
		map.put("android.databinding.ObservableParcelable", "androidx.databinding.ObservableParcelable");
		map.put("android.databinding.ObservableShort", "androidx.databinding.ObservableShort");
		map.put("android.databinding.OnRebindCallback", "androidx.databinding.OnRebindCallback");
		map.put("android.databinding.PropertyChangeRegistry", "androidx.databinding.PropertyChangeRegistry");
		map.put("android.databinding.Untaggable", "androidx.databinding.Untaggable");
		map.put("android.databinding.ViewDataBinding", "androidx.databinding.ViewDataBinding");
		map.put("android.databinding.ViewStubProxy", "androidx.databinding.ViewStubProxy");
		map.put("android.support.animation.AnimationHandler", "androidx.dynamicanimation.animation.AnimationHandler");
		map.put("android.support.animation.DynamicAnimation", "androidx.dynamicanimation.animation.DynamicAnimation");
		map.put("android.support.animation.FlingAnimation", "androidx.dynamicanimation.animation.FlingAnimation");
		map.put("android.support.animation.FloatPropertyCompat",
				"androidx.dynamicanimation.animation.FloatPropertyCompat");
		map.put("android.support.animation.FloatValueHolder", "androidx.dynamicanimation.animation.FloatValueHolder");
		map.put("android.support.animation.Force", "androidx.dynamicanimation.animation.Force");
		map.put("android.support.animation.SpringAnimation", "androidx.dynamicanimation.animation.SpringAnimation");
		map.put("android.support.animation.SpringForce", "androidx.dynamicanimation.animation.SpringForce");
		map.put("android.support.annotation.AnimatorRes", "androidx.annotation.AnimatorRes");
		map.put("android.support.annotation.AnimRes", "androidx.annotation.AnimRes");
		map.put("android.support.annotation.AnyRes", "androidx.annotation.AnyRes");
		map.put("android.support.annotation.AnyThread", "androidx.annotation.AnyThread");
		map.put("android.support.annotation.ArrayRes", "androidx.annotation.ArrayRes");
		map.put("android.support.annotation.AttrRes", "androidx.annotation.AttrRes");
		map.put("android.support.annotation.BinderThread", "androidx.annotation.BinderThread");
		map.put("android.support.annotation.BoolRes", "androidx.annotation.BoolRes");
		map.put("android.support.annotation.CallSuper", "androidx.annotation.CallSuper");
		map.put("android.support.annotation.CheckResult", "androidx.annotation.CheckResult");
		map.put("android.support.annotation.ColorInt", "androidx.annotation.ColorInt");
		map.put("android.support.annotation.ColorLong", "androidx.annotation.ColorLong");
		map.put("android.support.annotation.ColorRes", "androidx.annotation.ColorRes");
		map.put("android.support.annotation.DimenRes", "androidx.annotation.DimenRes");
		map.put("android.support.annotation.Dimension", "androidx.annotation.Dimension");
		map.put("android.support.annotation.DrawableRes", "androidx.annotation.DrawableRes");
		map.put("android.support.annotation.FloatRange", "androidx.annotation.FloatRange");
		map.put("android.support.annotation.FontRes", "androidx.annotation.FontRes");
		map.put("android.support.annotation.FractionRes", "androidx.annotation.FractionRes");
		map.put("android.support.annotation.GuardedBy", "androidx.annotation.GuardedBy");
		map.put("android.support.annotation.HalfFloat", "androidx.annotation.HalfFloat");
		map.put("android.support.annotation.IdRes", "androidx.annotation.IdRes");
		map.put("android.support.annotation.IntDef", "androidx.annotation.IntDef");
		map.put("android.support.annotation.IntegerRes", "androidx.annotation.IntegerRes");
		map.put("android.support.annotation.InterpolatorRes", "androidx.annotation.InterpolatorRes");
		map.put("android.support.annotation.IntRange", "androidx.annotation.IntRange");
		map.put("android.support.annotation.Keep", "androidx.annotation.Keep");
		map.put("android.support.annotation.LayoutRes", "androidx.annotation.LayoutRes");
		map.put("android.support.annotation.LongDef", "androidx.annotation.LongDef");
		map.put("android.support.annotation.MainThread", "androidx.annotation.MainThread");
		map.put("android.support.annotation.MenuRes", "androidx.annotation.MenuRes");
		map.put("android.support.annotation.NavigationRes", "androidx.annotation.NavigationRes");
		map.put("android.support.annotation.NonNull", "androidx.annotation.NonNull");
		map.put("android.support.annotation.Nullable", "androidx.annotation.Nullable");
		map.put("android.support.annotation.PluralsRes", "androidx.annotation.PluralsRes");
		map.put("android.support.annotation.Px", "androidx.annotation.Px");
		map.put("android.support.annotation.RawRes", "androidx.annotation.RawRes");
		map.put("android.support.annotation.RequiresApi", "androidx.annotation.RequiresApi");
		map.put("android.support.annotation.RequiresFeature", "androidx.annotation.RequiresFeature");
		map.put("android.support.annotation.RequiresPermission", "androidx.annotation.RequiresPermission");
		map.put("android.support.annotation.RestrictTo", "androidx.annotation.RestrictTo");
		map.put("android.support.annotation.Size", "androidx.annotation.Size");
		map.put("android.support.annotation.StringDef", "androidx.annotation.StringDef");
		map.put("android.support.annotation.StringRes", "androidx.annotation.StringRes");
		map.put("android.support.annotation.StyleableRes", "androidx.annotation.StyleableRes");
		map.put("android.support.annotation.StyleRes", "androidx.annotation.StyleRes");
		map.put("android.support.annotation.TransitionRes", "androidx.annotation.TransitionRes");
		map.put("android.support.annotation.UiThread", "androidx.annotation.UiThread");
		map.put("android.support.annotation.VisibleForTesting", "androidx.annotation.VisibleForTesting");
		map.put("android.support.annotation.WorkerThread", "androidx.annotation.WorkerThread");
		map.put("android.support.annotation.XmlRes", "androidx.annotation.XmlRes");
		map.put("android.support.app.recommendation.ContentRecommendation",
				"androidx.recommendation.app.ContentRecommendation");
		map.put("android.support.app.recommendation.RecommendationExtender",
				"androidx.recommendation.app.RecommendationExtender");
		map.put("android.support.compat.R", "androidx.core.R");
		map.put("android.support.constraint.Barrier", "androidx.constraintlayout.widget.Barrier");
		map.put("android.support.constraint.ConstraintHelper", "androidx.constraintlayout.widget.ConstraintHelper");
		map.put("android.support.constraint.ConstraintLayout", "androidx.constraintlayout.widget.ConstraintLayout");
		map.put("android.support.constraint.Constraints", "androidx.constraintlayout.widget.Constraints");
		map.put("android.support.constraint.ConstraintSet", "androidx.constraintlayout.widget.ConstraintSet");
		map.put("android.support.constraint.Group", "androidx.constraintlayout.widget.Group");
		map.put("android.support.constraint.Guideline", "androidx.constraintlayout.widget.Guideline");
		map.put("android.support.constraint.Placeholder", "androidx.constraintlayout.widget.Placeholder");
		map.put("android.support.constraint.R", "androidx.constraintlayout.widget.R");
		map.put("android.support.constraint.solver.ArrayLinkedVariables",
				"androidx.constraintlayout.solver.ArrayLinkedVariables");
		map.put("android.support.constraint.solver.ArrayRow", "androidx.constraintlayout.solver.ArrayRow");
		map.put("android.support.constraint.solver.Cache", "androidx.constraintlayout.solver.Cache");
		map.put("android.support.constraint.solver.GoalRow", "androidx.constraintlayout.solver.GoalRow");
		map.put("android.support.constraint.solver.LinearSystem", "androidx.constraintlayout.solver.LinearSystem");
		map.put("android.support.constraint.solver.Metrics", "androidx.constraintlayout.solver.Metrics");
		map.put("android.support.constraint.solver.Pools", "androidx.constraintlayout.solver.Pools");
		map.put("android.support.constraint.solver.SolverVariable", "androidx.constraintlayout.solver.SolverVariable");
		map.put("android.support.constraint.solver.widgets.Analyzer",
				"androidx.constraintlayout.solver.widgets.Analyzer");
		map.put("android.support.constraint.solver.widgets.Barrier",
				"androidx.constraintlayout.solver.widgets.Barrier");
		map.put("android.support.constraint.solver.widgets.Chain", "androidx.constraintlayout.solver.widgets.Chain");
		map.put("android.support.constraint.solver.widgets.ChainHead",
				"androidx.constraintlayout.solver.widgets.ChainHead");
		map.put("android.support.constraint.solver.widgets.ConstraintAnchor",
				"androidx.constraintlayout.solver.widgets.ConstraintAnchor");
		map.put("android.support.constraint.solver.widgets.ConstraintHorizontalLayout",
				"androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout");
		map.put("android.support.constraint.solver.widgets.ConstraintTableLayout",
				"androidx.constraintlayout.solver.widgets.ConstraintTableLayout");
		map.put("android.support.constraint.solver.widgets.ConstraintWidget",
				"androidx.constraintlayout.solver.widgets.ConstraintWidget");
		map.put("android.support.constraint.solver.widgets.ConstraintWidgetContainer",
				"androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer");
		map.put("android.support.constraint.solver.widgets.ConstraintWidgetGroup",
				"androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup");
		map.put("android.support.constraint.solver.widgets.Guideline",
				"androidx.constraintlayout.solver.widgets.Guideline");
		map.put("android.support.constraint.solver.widgets.Helper", "androidx.constraintlayout.solver.widgets.Helper");
		map.put("android.support.constraint.solver.widgets.Optimizer",
				"androidx.constraintlayout.solver.widgets.Optimizer");
		map.put("android.support.constraint.solver.widgets.Rectangle",
				"androidx.constraintlayout.solver.widgets.Rectangle");
		map.put("android.support.constraint.solver.widgets.ResolutionAnchor",
				"androidx.constraintlayout.solver.widgets.ResolutionAnchor");
		map.put("android.support.constraint.solver.widgets.ResolutionDimension",
				"androidx.constraintlayout.solver.widgets.ResolutionDimension");
		map.put("android.support.constraint.solver.widgets.ResolutionNode",
				"androidx.constraintlayout.solver.widgets.ResolutionNode");
		map.put("android.support.constraint.solver.widgets.Snapshot",
				"androidx.constraintlayout.solver.widgets.Snapshot");
		map.put("android.support.constraint.solver.widgets.WidgetContainer",
				"androidx.constraintlayout.solver.widgets.WidgetContainer");
		map.put("android.support.content.ContentPager", "androidx.contentpager.content.ContentPager");
		map.put("android.support.content.InMemoryCursor", "androidx.contentpager.content.InMemoryCursor");
		map.put("android.support.content.LoaderQueryRunner", "androidx.contentpager.content.LoaderQueryRunner");
		map.put("android.support.content.Query", "androidx.contentpager.content.Query");
		map.put("android.support.coordinatorlayout.R", "androidx.coordinatorlayout.R");
		map.put("android.support.customtabs.CustomTabsCallback", "androidx.browser.customtabs.CustomTabsCallback");
		map.put("android.support.customtabs.CustomTabsClient", "androidx.browser.customtabs.CustomTabsClient");
		map.put("android.support.customtabs.CustomTabsIntent", "androidx.browser.customtabs.CustomTabsIntent");
		map.put("android.support.customtabs.CustomTabsService", "androidx.browser.customtabs.CustomTabsService");
		map.put("android.support.customtabs.CustomTabsServiceConnection",
				"androidx.browser.customtabs.CustomTabsServiceConnection");
		map.put("android.support.customtabs.CustomTabsSession", "androidx.browser.customtabs.CustomTabsSession");
		map.put("android.support.customtabs.CustomTabsSessionToken",
				"androidx.browser.customtabs.CustomTabsSessionToken");
		map.put("android.support.customtabs.ICustomTabsCallback", "android.support.customtabs.ICustomTabsCallback");
		map.put("android.support.customtabs.ICustomTabsService", "android.support.customtabs.ICustomTabsService");
		map.put("android.support.customtabs.IPostMessageService", "android.support.customtabs.IPostMessageService");
		map.put("android.support.customtabs.PostMessageService", "androidx.browser.customtabs.PostMessageService");
		map.put("android.support.customtabs.PostMessageServiceConnection",
				"androidx.browser.customtabs.PostMessageServiceConnection");
		map.put("android.support.customtabs.R", "androidx.browser.R");
		map.put("android.support.customtabs.TrustedWebUtils", "androidx.browser.customtabs.TrustedWebUtils");
		map.put("android.support.design.animation.AnimationUtils",
				"com.google.android.material.animation.AnimationUtils");
		map.put("android.support.design.animation.AnimatorSetCompat",
				"com.google.android.material.animation.AnimatorSetCompat");
		map.put("android.support.design.animation.ArgbEvaluatorCompat",
				"com.google.android.material.animation.ArgbEvaluatorCompat");
		map.put("android.support.design.animation.ChildrenAlphaProperty",
				"com.google.android.material.animation.ChildrenAlphaProperty");
		map.put("android.support.design.animation.DrawableAlphaProperty",
				"com.google.android.material.animation.DrawableAlphaProperty");
		map.put("android.support.design.animation.ImageMatrixProperty",
				"com.google.android.material.animation.ImageMatrixProperty");
		map.put("android.support.design.animation.MatrixEvaluator",
				"com.google.android.material.animation.MatrixEvaluator");
		map.put("android.support.design.animation.MotionSpec", "com.google.android.material.animation.MotionSpec");
		map.put("android.support.design.animation.MotionTiming", "com.google.android.material.animation.MotionTiming");
		map.put("android.support.design.animation.Positioning", "com.google.android.material.animation.Positioning");
		map.put("android.support.design.behavior.HideBottomViewOnScrollBehavior",
				"com.google.android.material.behavior.HideBottomViewOnScrollBehavior");
		map.put("android.support.design.bottomappbar.BottomAppBar",
				"com.google.android.material.bottomappbar.BottomAppBar");
		map.put("android.support.design.bottomappbar.BottomAppBarTopEdgeTreatment",
				"com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment");
		map.put("android.support.design.bottomnavigation.LabelVisibilityMode",
				"com.google.android.material.bottomnavigation.LabelVisibilityMode");
		map.put("android.support.design.button.MaterialButton", "com.google.android.material.button.MaterialButton");
		map.put("android.support.design.button.MaterialButtonBackgroundDrawable",
				"com.google.android.material.button.MaterialButtonBackgroundDrawable");
		map.put("android.support.design.button.MaterialButtonHelper",
				"com.google.android.material.button.MaterialButtonHelper");
		map.put("android.support.design.canvas.CanvasCompat", "com.google.android.material.canvas.CanvasCompat");
		map.put("android.support.design.card.MaterialCardView", "com.google.android.material.card.MaterialCardView");
		map.put("android.support.design.card.MaterialCardViewHelper",
				"com.google.android.material.card.MaterialCardViewHelper");
		map.put("android.support.design.chip.Chip", "com.google.android.material.chip.Chip");
		map.put("android.support.design.chip.ChipDrawable", "com.google.android.material.chip.ChipDrawable");
		map.put("android.support.design.chip.ChipGroup", "com.google.android.material.chip.ChipGroup");
		map.put("android.support.design.circularreveal.cardview.CircularRevealCardView",
				"com.google.android.material.circularreveal.cardview.CircularRevealCardView");
		map.put("android.support.design.circularreveal.CircularRevealCompat",
				"com.google.android.material.circularreveal.CircularRevealCompat");
		map.put("android.support.design.circularreveal.CircularRevealFrameLayout",
				"com.google.android.material.circularreveal.CircularRevealFrameLayout");
		map.put("android.support.design.circularreveal.CircularRevealGridLayout",
				"com.google.android.material.circularreveal.CircularRevealGridLayout");
		map.put("android.support.design.circularreveal.CircularRevealHelper",
				"com.google.android.material.circularreveal.CircularRevealHelper");
		map.put("android.support.design.circularreveal.CircularRevealLinearLayout",
				"com.google.android.material.circularreveal.CircularRevealLinearLayout");
		map.put("android.support.design.circularreveal.CircularRevealRelativeLayout",
				"com.google.android.material.circularreveal.CircularRevealRelativeLayout");
		map.put("android.support.design.circularreveal.CircularRevealWidget",
				"com.google.android.material.circularreveal.CircularRevealWidget");
		map.put("android.support.design.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout",
				"com.google.android.material.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout");
		map.put("android.support.design.drawable.DrawableUtils", "com.google.android.material.drawable.DrawableUtils");
		map.put("android.support.design.expandable.ExpandableTransformationWidget",
				"com.google.android.material.expandable.ExpandableTransformationWidget");
		map.put("android.support.design.expandable.ExpandableWidget",
				"com.google.android.material.expandable.ExpandableWidget");
		map.put("android.support.design.expandable.ExpandableWidgetHelper",
				"com.google.android.material.expandable.ExpandableWidgetHelper");
		map.put("android.support.design.internal.BaselineLayout",
				"com.google.android.material.internal.BaselineLayout");
		map.put("android.support.design.internal.BottomNavigationItemView",
				"com.google.android.material.bottomnavigation.BottomNavigationItemView");
		map.put("android.support.design.internal.BottomNavigationMenu",
				"com.google.android.material.bottomnavigation.BottomNavigationMenu");
		map.put("android.support.design.internal.BottomNavigationMenuView",
				"com.google.android.material.bottomnavigation.BottomNavigationMenuView");
		map.put("android.support.design.internal.BottomNavigationPresenter",
				"com.google.android.material.bottomnavigation.BottomNavigationPresenter");
		map.put("android.support.design.internal.Experimental", "com.google.android.material.internal.Experimental");
		map.put("android.support.design.internal.FlowLayout", "com.google.android.material.internal.FlowLayout");
		map.put("android.support.design.internal.ForegroundLinearLayout",
				"com.google.android.material.internal.ForegroundLinearLayout");
		map.put("android.support.design.internal.NavigationMenu",
				"com.google.android.material.internal.NavigationMenu");
		map.put("android.support.design.internal.NavigationMenuItemView",
				"com.google.android.material.internal.NavigationMenuItemView");
		map.put("android.support.design.internal.NavigationMenuPresenter",
				"com.google.android.material.internal.NavigationMenuPresenter");
		map.put("android.support.design.internal.NavigationMenuView",
				"com.google.android.material.internal.NavigationMenuView");
		map.put("android.support.design.internal.NavigationSubMenu",
				"com.google.android.material.internal.NavigationSubMenu");
		map.put("android.support.design.internal.ParcelableSparseArray",
				"com.google.android.material.internal.ParcelableSparseArray");
		map.put("android.support.design.internal.ScrimInsetsFrameLayout",
				"com.google.android.material.internal.ScrimInsetsFrameLayout");
		map.put("android.support.design.internal.TextScale", "com.google.android.material.internal.TextScale");
		map.put("android.support.design.internal.ThemeEnforcement",
				"com.google.android.material.internal.ThemeEnforcement");
		map.put("android.support.design.internal.ViewUtils", "com.google.android.material.internal.ViewUtils");
		map.put("android.support.design.R", "com.google.android.material.R");
		map.put("android.support.design.resources.MaterialResources",
				"com.google.android.material.resources.MaterialResources");
		map.put("android.support.design.resources.TextAppearance",
				"com.google.android.material.resources.TextAppearance");
		map.put("android.support.design.resources.TextAppearanceConfig",
				"com.google.android.material.resources.TextAppearanceConfig");
		map.put("android.support.design.ripple.RippleUtils", "com.google.android.material.ripple.RippleUtils");
		map.put("android.support.design.shape.CornerTreatment", "com.google.android.material.shape.CornerTreatment");
		map.put("android.support.design.shape.CutCornerTreatment",
				"com.google.android.material.shape.CutCornerTreatment");
		map.put("android.support.design.shape.EdgeTreatment", "com.google.android.material.shape.EdgeTreatment");
		map.put("android.support.design.shape.InterpolateOnScrollPositionChangeHelper",
				"com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper");
		map.put("android.support.design.shape.MaterialShapeDrawable",
				"com.google.android.material.shape.MaterialShapeDrawable");
		map.put("android.support.design.shape.RoundedCornerTreatment",
				"com.google.android.material.shape.RoundedCornerTreatment");
		map.put("android.support.design.shape.ShapePath", "com.google.android.material.shape.ShapePath");
		map.put("android.support.design.shape.ShapePathModel", "com.google.android.material.shape.ShapePathModel");
		map.put("android.support.design.shape.TriangleEdgeTreatment",
				"com.google.android.material.shape.TriangleEdgeTreatment");
		map.put("android.support.design.snackbar.ContentViewCallback",
				"com.google.android.material.snackbar.ContentViewCallback");
		map.put("android.support.design.stateful.ExtendableSavedState",
				"com.google.android.material.stateful.ExtendableSavedState");
		map.put("android.support.design.theme.MaterialComponentsViewInflater",
				"com.google.android.material.theme.MaterialComponentsViewInflater");
		map.put("android.support.design.transformation.ExpandableBehavior",
				"com.google.android.material.transformation.ExpandableBehavior");
		map.put("android.support.design.transformation.ExpandableTransformationBehavior",
				"com.google.android.material.transformation.ExpandableTransformationBehavior");
		map.put("android.support.design.transformation.FabTransformationBehavior",
				"com.google.android.material.transformation.FabTransformationBehavior");
		map.put("android.support.design.transformation.FabTransformationScrimBehavior",
				"com.google.android.material.transformation.FabTransformationScrimBehavior");
		map.put("android.support.design.transformation.FabTransformationSheetBehavior",
				"com.google.android.material.transformation.FabTransformationSheetBehavior");
		map.put("android.support.design.transformation.TransformationChildCard",
				"com.google.android.material.transformation.TransformationChildCard");
		map.put("android.support.design.transformation.TransformationChildLayout",
				"com.google.android.material.transformation.TransformationChildLayout");
		map.put("android.support.design.widget.AppBarLayout", "com.google.android.material.appbar.AppBarLayout");
		map.put("android.support.design.widget.BaseTransientBottomBar",
				"com.google.android.material.snackbar.BaseTransientBottomBar");
		map.put("android.support.design.widget.BottomNavigationView",
				"com.google.android.material.bottomnavigation.BottomNavigationView");
		map.put("android.support.design.widget.BottomSheetBehavior",
				"com.google.android.material.bottomsheet.BottomSheetBehavior");
		map.put("android.support.design.widget.BottomSheetDialog",
				"com.google.android.material.bottomsheet.BottomSheetDialog");
		map.put("android.support.design.widget.BottomSheetDialogFragment",
				"com.google.android.material.bottomsheet.BottomSheetDialogFragment");
		map.put("android.support.design.widget.CheckableImageButton",
				"com.google.android.material.internal.CheckableImageButton");
		map.put("android.support.design.widget.CircularBorderDrawable",
				"com.google.android.material.internal.CircularBorderDrawable");
		map.put("android.support.design.widget.CircularBorderDrawableLollipop",
				"com.google.android.material.internal.CircularBorderDrawableLollipop");
		map.put("android.support.design.widget.CollapsingTextHelper",
				"com.google.android.material.internal.CollapsingTextHelper");
		map.put("android.support.design.widget.CollapsingToolbarLayout",
				"com.google.android.material.appbar.CollapsingToolbarLayout");
		map.put("android.support.design.widget.CoordinatorLayout",
				"androidx.coordinatorlayout.widget.CoordinatorLayout");
		map.put("android.support.design.widget.CutoutDrawable", "com.google.android.material.textfield.CutoutDrawable");
		map.put("android.support.design.widget.DescendantOffsetUtils",
				"com.google.android.material.internal.DescendantOffsetUtils");
		map.put("android.support.design.widget.DrawableUtils", "com.google.android.material.internal.DrawableUtils");
		map.put("android.support.design.widget.FloatingActionButton",
				"com.google.android.material.floatingactionbutton.FloatingActionButton");
		map.put("android.support.design.widget.FloatingActionButtonImpl",
				"com.google.android.material.floatingactionbutton.FloatingActionButtonImpl");
		map.put("android.support.design.widget.FloatingActionButtonImplLollipop",
				"com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop");
		map.put("android.support.design.widget.HeaderBehavior", "com.google.android.material.appbar.HeaderBehavior");
		map.put("android.support.design.widget.HeaderScrollingViewBehavior",
				"com.google.android.material.appbar.HeaderScrollingViewBehavior");
		map.put("android.support.design.widget.IndicatorViewController",
				"com.google.android.material.textfield.IndicatorViewController");
		map.put("android.support.design.widget.MathUtils", "com.google.android.material.math.MathUtils");
		map.put("android.support.design.widget.NavigationView",
				"com.google.android.material.navigation.NavigationView");
		map.put("android.support.design.widget.ShadowDrawableWrapper",
				"com.google.android.material.shadow.ShadowDrawableWrapper");
		map.put("android.support.design.widget.ShadowViewDelegate",
				"com.google.android.material.shadow.ShadowViewDelegate");
		map.put("android.support.design.widget.Snackbar", "com.google.android.material.snackbar.Snackbar");
		map.put("android.support.design.widget.SnackbarContentLayout",
				"com.google.android.material.snackbar.SnackbarContentLayout");
		map.put("android.support.design.widget.SnackbarManager",
				"com.google.android.material.snackbar.SnackbarManager");
		map.put("android.support.design.widget.StateListAnimator",
				"com.google.android.material.internal.StateListAnimator");
		map.put("android.support.design.widget.SwipeDismissBehavior",
				"com.google.android.material.behavior.SwipeDismissBehavior");
		map.put("android.support.design.widget.TabItem", "com.google.android.material.tabs.TabItem");
		map.put("android.support.design.widget.TabLayout", "com.google.android.material.tabs.TabLayout");
		map.put("android.support.design.widget.TextInputEditText",
				"com.google.android.material.textfield.TextInputEditText");
		map.put("android.support.design.widget.TextInputLayout",
				"com.google.android.material.textfield.TextInputLayout");
		map.put("android.support.design.widget.ViewOffsetBehavior",
				"com.google.android.material.appbar.ViewOffsetBehavior");
		map.put("android.support.design.widget.ViewOffsetHelper",
				"com.google.android.material.appbar.ViewOffsetHelper");
		map.put("android.support.design.widget.ViewUtilsLollipop",
				"com.google.android.material.appbar.ViewUtilsLollipop");
		map.put("android.support.design.widget.VisibilityAwareImageButton",
				"com.google.android.material.internal.VisibilityAwareImageButton");
		map.put("android.support.graphics.drawable.AndroidResources",
				"androidx.vectordrawable.graphics.drawable.AndroidResources");
		map.put("android.support.graphics.drawable.Animatable2Compat",
				"androidx.vectordrawable.graphics.drawable.Animatable2Compat");
		map.put("android.support.graphics.drawable.AnimatedVectorDrawableCompat",
				"androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat");
		map.put("android.support.graphics.drawable.AnimationUtilsCompat",
				"androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat");
		map.put("android.support.graphics.drawable.AnimatorInflaterCompat",
				"androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat");
		map.put("android.support.graphics.drawable.ArgbEvaluator",
				"androidx.vectordrawable.graphics.drawable.ArgbEvaluator");
		map.put("android.support.graphics.drawable.PathInterpolatorCompat",
				"androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat");
		map.put("android.support.graphics.drawable.VectorDrawableCommon",
				"androidx.vectordrawable.graphics.drawable.VectorDrawableCommon");
		map.put("android.support.graphics.drawable.VectorDrawableCompat",
				"androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
		map.put("android.support.media.ExifInterface", "androidx.exifinterface.media.ExifInterface");
		map.put("android.support.media.tv.BasePreviewProgram", "androidx.tvprovider.media.tv.BasePreviewProgram");
		map.put("android.support.media.tv.BaseProgram", "androidx.tvprovider.media.tv.BaseProgram");
		map.put("android.support.media.tv.Channel", "androidx.tvprovider.media.tv.Channel");
		map.put("android.support.media.tv.ChannelLogoUtils", "androidx.tvprovider.media.tv.ChannelLogoUtils");
		map.put("android.support.media.tv.CollectionUtils", "androidx.tvprovider.media.tv.CollectionUtils");
		map.put("android.support.media.tv.PreviewChannel", "androidx.tvprovider.media.tv.PreviewChannel");
		map.put("android.support.media.tv.PreviewChannelHelper", "androidx.tvprovider.media.tv.PreviewChannelHelper");
		map.put("android.support.media.tv.PreviewProgram", "androidx.tvprovider.media.tv.PreviewProgram");
		map.put("android.support.media.tv.Program", "androidx.tvprovider.media.tv.Program");
		map.put("android.support.media.tv.TvContractCompat", "androidx.tvprovider.media.tv.TvContractCompat");
		map.put("android.support.media.tv.TvContractUtils", "androidx.tvprovider.media.tv.TvContractUtils");
		map.put("android.support.media.tv.WatchNextProgram", "androidx.tvprovider.media.tv.WatchNextProgram");
		map.put("android.support.media2.BaseRemoteMediaPlayerConnector",
				"android.support.media2.BaseRemoteMediaPlayerConnector");
		map.put("android.support.media2.DataSourceDesc2", "android.support.media2.DataSourceDesc2");
		map.put("android.support.media2.MediaPlayerConnector", "android.support.media2.MediaPlayerConnector");
		map.put("android.support.media2.MediaPlaylistAgent", "android.support.media2.MediaPlaylistAgent");
		map.put("android.support.media2.MediaSession2", "android.support.media2.MediaSession2");
		map.put("android.support.mediacompat.R", "androidx.media.R");
		map.put("android.support.multidex.MultiDex", "androidx.multidex.MultiDex");
		map.put("android.support.multidex.MultiDexApplication", "androidx.multidex.MultiDexApplication");
		map.put("android.support.multidex.MultiDexExtractor", "androidx.multidex.MultiDexExtractor");
		map.put("android.support.multidex.ZipUtil", "androidx.multidex.ZipUtil");
		map.put("android.support.percent.PercentFrameLayout", "androidx.percentlayout.widget.PercentFrameLayout");
		map.put("android.support.percent.PercentLayoutHelper", "androidx.percentlayout.widget.PercentLayoutHelper");
		map.put("android.support.percent.PercentRelativeLayout", "androidx.percentlayout.widget.PercentRelativeLayout");
		map.put("android.support.percent.R", "androidx.percentlayout.R");
		map.put("android.support.test.annotation.Beta", "androidx.test.annotation.Beta");
		map.put("android.support.test.annotation.UiThreadTest", "androidx.test.annotation.UiThreadTest");
		map.put("android.support.test.espresso.accessibility.AccessibilityChecks",
				"androidx.test.espresso.accessibility.AccessibilityChecks");
		map.put("android.support.test.espresso.action.AdapterDataLoaderAction",
				"androidx.test.espresso.action.AdapterDataLoaderAction");
		map.put("android.support.test.espresso.action.AdapterDataLoaderActionRemoteMsg",
				"androidx.test.espresso.action.AdapterDataLoaderActionRemoteMsg");
		map.put("android.support.test.espresso.action.AdapterViewProtocol",
				"androidx.test.espresso.action.AdapterViewProtocol");
		map.put("android.support.test.espresso.action.AdapterViewProtocols",
				"androidx.test.espresso.action.AdapterViewProtocols");
		map.put("android.support.test.espresso.action.CloseKeyboardAction",
				"androidx.test.espresso.action.CloseKeyboardAction");
		map.put("android.support.test.espresso.action.CoordinatesProvider",
				"androidx.test.espresso.action.CoordinatesProvider");
		map.put("android.support.test.espresso.action.EditorAction", "androidx.test.espresso.action.EditorAction");
		map.put("android.support.test.espresso.action.EspressoKey", "androidx.test.espresso.action.EspressoKey");
		map.put("android.support.test.espresso.action.GeneralClickAction",
				"androidx.test.espresso.action.GeneralClickAction");
		map.put("android.support.test.espresso.action.GeneralClickActionRemoteMessage",
				"androidx.test.espresso.action.GeneralClickActionRemoteMessage");
		map.put("android.support.test.espresso.action.GeneralLocation",
				"androidx.test.espresso.action.GeneralLocation");
		map.put("android.support.test.espresso.action.GeneralLocationRemoteMessage",
				"androidx.test.espresso.action.GeneralLocationRemoteMessage");
		map.put("android.support.test.espresso.action.GeneralSwipeAction",
				"androidx.test.espresso.action.GeneralSwipeAction");
		map.put("android.support.test.espresso.action.GeneralSwipeActionRemoteMessage",
				"androidx.test.espresso.action.GeneralSwipeActionRemoteMessage");
		map.put("android.support.test.espresso.action.KeyEventAction", "androidx.test.espresso.action.KeyEventAction");
		map.put("android.support.test.espresso.action.KeyEventActionBase",
				"androidx.test.espresso.action.KeyEventActionBase");
		map.put("android.support.test.espresso.action.MotionEvents", "androidx.test.espresso.action.MotionEvents");
		map.put("android.support.test.espresso.action.OpenLinkAction", "androidx.test.espresso.action.OpenLinkAction");
		map.put("android.support.test.espresso.action.PrecisionDescriber",
				"androidx.test.espresso.action.PrecisionDescriber");
		map.put("android.support.test.espresso.action.Press", "androidx.test.espresso.action.Press");
		map.put("android.support.test.espresso.action.PressBackAction",
				"androidx.test.espresso.action.PressBackAction");
		map.put("android.support.test.espresso.action.PressRemoteMessage",
				"androidx.test.espresso.action.PressRemoteMessage");
		map.put("android.support.test.espresso.action.RemoteViewActions",
				"androidx.test.espresso.action.RemoteViewActions");
		map.put("android.support.test.espresso.action.RepeatActionUntilViewState",
				"androidx.test.espresso.action.RepeatActionUntilViewState");
		map.put("android.support.test.espresso.action.ReplaceTextAction",
				"androidx.test.espresso.action.ReplaceTextAction");
		map.put("android.support.test.espresso.action.ScrollToAction", "androidx.test.espresso.action.ScrollToAction");
		map.put("android.support.test.espresso.action.Swipe", "androidx.test.espresso.action.Swipe");
		map.put("android.support.test.espresso.action.Swiper", "androidx.test.espresso.action.Swiper");
		map.put("android.support.test.espresso.action.SwipeRemoteMessage",
				"androidx.test.espresso.action.SwipeRemoteMessage");
		map.put("android.support.test.espresso.action.Tap", "androidx.test.espresso.action.Tap");
		map.put("android.support.test.espresso.action.Tapper", "androidx.test.espresso.action.Tapper");
		map.put("android.support.test.espresso.action.TapRemoteMessage",
				"androidx.test.espresso.action.TapRemoteMessage");
		map.put("android.support.test.espresso.action.TranslatedCoordinatesProvider",
				"androidx.test.espresso.action.TranslatedCoordinatesProvider");
		map.put("android.support.test.espresso.action.TranslatedCoordinatesProviderRemoteMessage",
				"androidx.test.espresso.action.TranslatedCoordinatesProviderRemoteMessage");
		map.put("android.support.test.espresso.action.TypeTextAction", "androidx.test.espresso.action.TypeTextAction");
		map.put("android.support.test.espresso.action.ViewActions", "androidx.test.espresso.action.ViewActions");
		map.put("android.support.test.espresso.AmbiguousViewMatcherException",
				"androidx.test.espresso.AmbiguousViewMatcherException");
		map.put("android.support.test.espresso.AppNotIdleException", "androidx.test.espresso.AppNotIdleException");
		map.put("android.support.test.espresso.assertion.LayoutAssertions",
				"androidx.test.espresso.assertion.LayoutAssertions");
		map.put("android.support.test.espresso.assertion.PositionAssertions",
				"androidx.test.espresso.assertion.PositionAssertions");
		map.put("android.support.test.espresso.assertion.RemoteViewAssertions",
				"androidx.test.espresso.assertion.RemoteViewAssertions");
		map.put("android.support.test.espresso.assertion.ViewAssertions",
				"androidx.test.espresso.assertion.ViewAssertions");
		map.put("android.support.test.espresso.base.ActiveRootLister", "androidx.test.espresso.base.ActiveRootLister");
		map.put("android.support.test.espresso.base.AsyncTaskPoolMonitor",
				"androidx.test.espresso.base.AsyncTaskPoolMonitor");
		map.put("android.support.test.espresso.base.BaseLayerModule", "androidx.test.espresso.base.BaseLayerModule");
		map.put("android.support.test.espresso.base.BaseLayerModule_FailureHandlerHolder_Factory",
				"androidx.test.espresso.base.BaseLayerModule_FailureHandlerHolder_Factory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideActiveRootListerFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideActiveRootListerFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideDynamicNotiferFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideDynamicNotiferFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideEventInjectorFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideEventInjectorFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideFailureHanderFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideFailureHanderFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideFailureHandlerFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideFailureHandlerFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideLifecycleMonitorFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideLifecycleMonitorFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideMainLooperFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideMainLooperFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideMainThreadExecutorFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideMainThreadExecutorFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideRemoteExecutorFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideRemoteExecutorFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideSdkAsyncTaskMonitorFactory");
		map.put("android.support.test.espresso.base.BaseLayerModule_ProvideTargetContextFactory",
				"androidx.test.espresso.base.BaseLayerModule_ProvideTargetContextFactory");
		map.put("android.support.test.espresso.base.CompatAsyncTask", "androidx.test.espresso.base.CompatAsyncTask");
		map.put("android.support.test.espresso.base.Default", "androidx.test.espresso.base.Default");
		map.put("android.support.test.espresso.base.DefaultFailureHandler",
				"androidx.test.espresso.base.DefaultFailureHandler");
		map.put("android.support.test.espresso.base.EventInjectionStrategy",
				"androidx.test.espresso.base.EventInjectionStrategy");
		map.put("android.support.test.espresso.base.EventInjector", "androidx.test.espresso.base.EventInjector");
		map.put("android.support.test.espresso.base.IdleNotifier", "androidx.test.espresso.base.IdleNotifier");
		map.put("android.support.test.espresso.base.IdlingResourceRegistry",
				"androidx.test.espresso.base.IdlingResourceRegistry");
		map.put("android.support.test.espresso.base.IdlingResourceRegistry_Factory",
				"androidx.test.espresso.base.IdlingResourceRegistry_Factory");
		map.put("android.support.test.espresso.base.IdlingUiController",
				"androidx.test.espresso.base.IdlingUiController");
		map.put("android.support.test.espresso.base.InputManagerEventInjectionStrategy",
				"androidx.test.espresso.base.InputManagerEventInjectionStrategy");
		map.put("android.support.test.espresso.base.Interrogator", "androidx.test.espresso.base.Interrogator");
		map.put("android.support.test.espresso.base.InterruptableUiController",
				"androidx.test.espresso.base.InterruptableUiController");
		map.put("android.support.test.espresso.base.LooperIdlingResourceInterrogationHandler",
				"androidx.test.espresso.base.LooperIdlingResourceInterrogationHandler");
		map.put("android.support.test.espresso.base.MainThread", "androidx.test.espresso.base.MainThread");
		map.put("android.support.test.espresso.base.NoopIdleNotificationCallbackIdleNotifierProvider",
				"androidx.test.espresso.base.NoopIdleNotificationCallbackIdleNotifierProvider");
		map.put("android.support.test.espresso.base.NoopRunnableIdleNotifier",
				"androidx.test.espresso.base.NoopRunnableIdleNotifier");
		map.put("android.support.test.espresso.base.RootsOracle", "androidx.test.espresso.base.RootsOracle");
		map.put("android.support.test.espresso.base.RootsOracle_Factory",
				"androidx.test.espresso.base.RootsOracle_Factory");
		map.put("android.support.test.espresso.base.RootViewPicker", "androidx.test.espresso.base.RootViewPicker");
		map.put("android.support.test.espresso.base.RootViewPicker_Factory",
				"androidx.test.espresso.base.RootViewPicker_Factory");
		map.put("android.support.test.espresso.base.RootViewPicker_RootResultFetcher_Factory",
				"androidx.test.espresso.base.RootViewPicker_RootResultFetcher_Factory");
		map.put("android.support.test.espresso.base.RootViewPickerScope",
				"androidx.test.espresso.base.RootViewPickerScope");
		map.put("android.support.test.espresso.base.SdkAsyncTask", "androidx.test.espresso.base.SdkAsyncTask");
		map.put("android.support.test.espresso.base.ThreadPoolExecutorExtractor",
				"androidx.test.espresso.base.ThreadPoolExecutorExtractor");
		map.put("android.support.test.espresso.base.ThreadPoolExecutorExtractor_Factory",
				"androidx.test.espresso.base.ThreadPoolExecutorExtractor_Factory");
		map.put("android.support.test.espresso.base.UiControllerImpl", "androidx.test.espresso.base.UiControllerImpl");
		map.put("android.support.test.espresso.base.UiControllerImpl_Factory",
				"androidx.test.espresso.base.UiControllerImpl_Factory");
		map.put("android.support.test.espresso.base.UiControllerModule",
				"androidx.test.espresso.base.UiControllerModule");
		map.put("android.support.test.espresso.base.ViewFinderImpl", "androidx.test.espresso.base.ViewFinderImpl");
		map.put("android.support.test.espresso.base.ViewFinderImpl_Factory",
				"androidx.test.espresso.base.ViewFinderImpl_Factory");
		map.put("android.support.test.espresso.base.WindowManagerEventInjectionStrategy",
				"androidx.test.espresso.base.WindowManagerEventInjectionStrategy");
		map.put("android.support.test.espresso.BaseLayerComponent", "androidx.test.espresso.BaseLayerComponent");
		map.put("android.support.test.espresso.contrib.AccessibilityChecks",
				"androidx.test.espresso.contrib.AccessibilityChecks");
		map.put("android.support.test.espresso.contrib.ActivityResultMatchers",
				"androidx.test.espresso.contrib.ActivityResultMatchers");
		map.put("android.support.test.espresso.contrib.Checks", "androidx.test.espresso.contrib.Checks");
		map.put("android.support.test.espresso.contrib.DrawerActions", "androidx.test.espresso.contrib.DrawerActions");
		map.put("android.support.test.espresso.contrib.DrawerMatchers",
				"androidx.test.espresso.contrib.DrawerMatchers");
		map.put("android.support.test.espresso.contrib.NavigationViewActions",
				"androidx.test.espresso.contrib.NavigationViewActions");
		map.put("android.support.test.espresso.contrib.PickerActions", "androidx.test.espresso.contrib.PickerActions");
		map.put("android.support.test.espresso.contrib.RecyclerViewActions",
				"androidx.test.espresso.contrib.RecyclerViewActions");
		map.put("android.support.test.espresso.contrib.ViewPagerActions",
				"androidx.test.espresso.contrib.ViewPagerActions");
		map.put("android.support.test.espresso.DaggerBaseLayerComponent",
				"androidx.test.espresso.DaggerBaseLayerComponent");
		map.put("android.support.test.espresso.DataInteraction", "androidx.test.espresso.DataInteraction");
		map.put("android.support.test.espresso.DataInteractionRemote", "androidx.test.espresso.DataInteractionRemote");
		map.put("android.support.test.espresso.Espresso", "androidx.test.espresso.Espresso");
		map.put("android.support.test.espresso.EspressoException", "androidx.test.espresso.EspressoException");
		map.put("android.support.test.espresso.FailureHandler", "androidx.test.espresso.FailureHandler");
		map.put("android.support.test.espresso.GraphHolder", "androidx.test.espresso.GraphHolder");
		map.put("android.support.test.espresso.idling.concurrent.IdlingScheduledThreadPoolExecutor",
				"androidx.test.espresso.idling.concurrent.IdlingScheduledThreadPoolExecutor");
		map.put("android.support.test.espresso.idling.concurrent.IdlingThreadPoolExecutor",
				"androidx.test.espresso.idling.concurrent.IdlingThreadPoolExecutor");
		map.put("android.support.test.espresso.idling.CountingIdlingResource",
				"androidx.test.espresso.idling.CountingIdlingResource");
		map.put("android.support.test.espresso.idling.net.UriIdlingResource",
				"androidx.test.espresso.idling.net.UriIdlingResource");
		map.put("android.support.test.espresso.IdlingPolicies", "androidx.test.espresso.IdlingPolicies");
		map.put("android.support.test.espresso.IdlingPolicy", "androidx.test.espresso.IdlingPolicy");
		map.put("android.support.test.espresso.IdlingRegistry", "androidx.test.espresso.IdlingRegistry");
		map.put("android.support.test.espresso.IdlingResource", "androidx.test.espresso.IdlingResource");
		map.put("android.support.test.espresso.IdlingResourceTimeoutException",
				"androidx.test.espresso.IdlingResourceTimeoutException");
		map.put("android.support.test.espresso.InjectEventSecurityException",
				"androidx.test.espresso.InjectEventSecurityException");
		map.put("android.support.test.espresso.intent.ActivityResultFunction",
				"androidx.test.espresso.intent.ActivityResultFunction");
		map.put("android.support.test.espresso.intent.Checks", "androidx.test.espresso.intent.Checks");
		map.put("android.support.test.espresso.intent.Intents", "androidx.test.espresso.intent.Intents");
		map.put("android.support.test.espresso.intent.matcher.BundleMatchers",
				"androidx.test.espresso.intent.matcher.BundleMatchers");
		map.put("android.support.test.espresso.intent.matcher.ComponentNameMatchers",
				"androidx.test.espresso.intent.matcher.ComponentNameMatchers");
		map.put("android.support.test.espresso.intent.matcher.IntentMatchers",
				"androidx.test.espresso.intent.matcher.IntentMatchers");
		map.put("android.support.test.espresso.intent.matcher.UriMatchers",
				"androidx.test.espresso.intent.matcher.UriMatchers");
		map.put("android.support.test.espresso.intent.OngoingStubbing",
				"androidx.test.espresso.intent.OngoingStubbing");
		map.put("android.support.test.espresso.intent.ResettingStubber",
				"androidx.test.espresso.intent.ResettingStubber");
		map.put("android.support.test.espresso.intent.ResettingStubberImpl",
				"androidx.test.espresso.intent.ResettingStubberImpl");
		map.put("android.support.test.espresso.intent.ResolvedIntent", "androidx.test.espresso.intent.ResolvedIntent");
		map.put("android.support.test.espresso.intent.ResolvedIntentImpl",
				"androidx.test.espresso.intent.ResolvedIntentImpl");
		map.put("android.support.test.espresso.intent.rule.IntentsTestRule",
				"androidx.test.espresso.intent.rule.IntentsTestRule");
		map.put("android.support.test.espresso.intent.VerifiableIntent",
				"androidx.test.espresso.intent.VerifiableIntent");
		map.put("android.support.test.espresso.intent.VerifiableIntentImpl",
				"androidx.test.espresso.intent.VerifiableIntentImpl");
		map.put("android.support.test.espresso.intent.VerificationMode",
				"androidx.test.espresso.intent.VerificationMode");
		map.put("android.support.test.espresso.intent.VerificationModes",
				"androidx.test.espresso.intent.VerificationModes");
		map.put("android.support.test.espresso.InteractionResultsHandler",
				"androidx.test.espresso.InteractionResultsHandler");
		map.put("android.support.test.espresso.matcher.BoundedMatcher",
				"androidx.test.espresso.matcher.BoundedMatcher");
		map.put("android.support.test.espresso.matcher.CursorMatchers",
				"androidx.test.espresso.matcher.CursorMatchers");
		map.put("android.support.test.espresso.matcher.HasBackgroundMatcher",
				"androidx.test.espresso.matcher.HasBackgroundMatcher");
		map.put("android.support.test.espresso.matcher.LayoutMatchers",
				"androidx.test.espresso.matcher.LayoutMatchers");
		map.put("android.support.test.espresso.matcher.PreferenceMatchers",
				"androidx.test.espresso.matcher.PreferenceMatchers");
		map.put("android.support.test.espresso.matcher.RemoteHamcrestCoreMatchers13",
				"androidx.test.espresso.matcher.RemoteHamcrestCoreMatchers13");
		map.put("android.support.test.espresso.matcher.RemoteRootMatchers",
				"androidx.test.espresso.matcher.RemoteRootMatchers");
		map.put("android.support.test.espresso.matcher.RemoteViewMatchers",
				"androidx.test.espresso.matcher.RemoteViewMatchers");
		map.put("android.support.test.espresso.matcher.RootMatchers", "androidx.test.espresso.matcher.RootMatchers");
		map.put("android.support.test.espresso.matcher.ViewMatchers", "androidx.test.espresso.matcher.ViewMatchers");
		map.put("android.support.test.espresso.NoActivityResumedException",
				"androidx.test.espresso.NoActivityResumedException");
		map.put("android.support.test.espresso.NoMatchingRootException",
				"androidx.test.espresso.NoMatchingRootException");
		map.put("android.support.test.espresso.NoMatchingViewException",
				"androidx.test.espresso.NoMatchingViewException");
		map.put("android.support.test.espresso.PerformException", "androidx.test.espresso.PerformException");
		map.put("android.support.test.espresso.proto.action.ViewActions",
				"androidx.test.espresso.proto.action.ViewActions");
		map.put("android.support.test.espresso.proto.assertion.ViewAssertions",
				"androidx.test.espresso.proto.assertion.ViewAssertions");
		map.put("android.support.test.espresso.proto.matcher.RootMatchers",
				"androidx.test.espresso.proto.matcher.RootMatchers");
		map.put("android.support.test.espresso.proto.matcher.ViewMatchers",
				"androidx.test.espresso.proto.matcher.ViewMatchers");
		map.put("android.support.test.espresso.proto.matcher13.HamcrestMatchersv13",
				"androidx.test.espresso.proto.matcher13.HamcrestMatchersv13");
		map.put("android.support.test.espresso.proto.UiInteraction", "androidx.test.espresso.proto.UiInteraction");
		map.put("android.support.test.espresso.remote.annotation.RemoteMsgConstructor",
				"androidx.test.espresso.remote.annotation.RemoteMsgConstructor");
		map.put("android.support.test.espresso.remote.annotation.RemoteMsgField",
				"androidx.test.espresso.remote.annotation.RemoteMsgField");
		map.put("android.support.test.espresso.remote.AnyToTypeConverter",
				"androidx.test.espresso.remote.AnyToTypeConverter");
		map.put("android.support.test.espresso.remote.Bindable", "androidx.test.espresso.remote.Bindable");
		map.put("android.support.test.espresso.remote.BuilderReflector",
				"androidx.test.espresso.remote.BuilderReflector");
		map.put("android.support.test.espresso.remote.ByteStringToParcelableConverter",
				"androidx.test.espresso.remote.ByteStringToParcelableConverter");
		map.put("android.support.test.espresso.remote.ByteStringToTypeConverter",
				"androidx.test.espresso.remote.ByteStringToTypeConverter");
		map.put("android.support.test.espresso.remote.ConstructorInvocation",
				"androidx.test.espresso.remote.ConstructorInvocation");
		map.put("android.support.test.espresso.remote.Converter", "androidx.test.espresso.remote.Converter");
		map.put("android.support.test.espresso.remote.EspressoRemote", "androidx.test.espresso.remote.EspressoRemote");
		map.put("android.support.test.espresso.remote.EspressoRemoteMessage",
				"androidx.test.espresso.remote.EspressoRemoteMessage");
		map.put("android.support.test.espresso.remote.FieldDescriptor",
				"androidx.test.espresso.remote.FieldDescriptor");
		map.put("android.support.test.espresso.remote.GenericRemoteMessage",
				"androidx.test.espresso.remote.GenericRemoteMessage");
		map.put("android.support.test.espresso.remote.IInteractionExecutionStatus",
				"androidx.test.espresso.remote.IInteractionExecutionStatus");
		map.put("android.support.test.espresso.remote.InteractionRequest",
				"androidx.test.espresso.remote.InteractionRequest");
		map.put("android.support.test.espresso.remote.InteractionResponse",
				"androidx.test.espresso.remote.InteractionResponse");
		map.put("android.support.test.espresso.remote.MethodInvocation",
				"androidx.test.espresso.remote.MethodInvocation");
		map.put("android.support.test.espresso.remote.NoopRemoteInteraction",
				"androidx.test.espresso.remote.NoopRemoteInteraction");
		map.put("android.support.test.espresso.remote.NoRemoteEspressoInstanceException",
				"androidx.test.espresso.remote.NoRemoteEspressoInstanceException");
		map.put("android.support.test.espresso.remote.ParcelableToByteStringConverter",
				"androidx.test.espresso.remote.ParcelableToByteStringConverter");
		map.put("android.support.test.espresso.remote.ProtoReflector", "androidx.test.espresso.remote.ProtoReflector");
		map.put("android.support.test.espresso.remote.ProtoUtils", "androidx.test.espresso.remote.ProtoUtils");
		map.put("android.support.test.espresso.remote.RemoteDescriptor",
				"androidx.test.espresso.remote.RemoteDescriptor");
		map.put("android.support.test.espresso.remote.RemoteDescriptorRegistry",
				"androidx.test.espresso.remote.RemoteDescriptorRegistry");
		map.put("android.support.test.espresso.remote.RemoteEspressoException",
				"androidx.test.espresso.remote.RemoteEspressoException");
		map.put("android.support.test.espresso.remote.RemoteInteraction",
				"androidx.test.espresso.remote.RemoteInteraction");
		map.put("android.support.test.espresso.remote.RemoteInteractionRegistry",
				"androidx.test.espresso.remote.RemoteInteractionRegistry");
		map.put("android.support.test.espresso.remote.RemoteMessageDeserializer",
				"androidx.test.espresso.remote.RemoteMessageDeserializer");
		map.put("android.support.test.espresso.remote.RemoteMessageSerializer",
				"androidx.test.espresso.remote.RemoteMessageSerializer");
		map.put("android.support.test.espresso.remote.RemoteProtocolException",
				"androidx.test.espresso.remote.RemoteProtocolException");
		map.put("android.support.test.espresso.remote.TypeProtoConverters",
				"androidx.test.espresso.remote.TypeProtoConverters");
		map.put("android.support.test.espresso.remote.TypeToAnyConverter",
				"androidx.test.espresso.remote.TypeToAnyConverter");
		map.put("android.support.test.espresso.remote.TypeToByteStringConverter",
				"androidx.test.espresso.remote.TypeToByteStringConverter");
		map.put("android.support.test.espresso.Root", "androidx.test.espresso.Root");
		map.put("android.support.test.espresso.UiController", "androidx.test.espresso.UiController");
		map.put("android.support.test.espresso.util.ActivityLifecycles",
				"androidx.test.espresso.util.ActivityLifecycles");
		map.put("android.support.test.espresso.util.EspressoOptional", "androidx.test.espresso.util.EspressoOptional");
		map.put("android.support.test.espresso.util.HumanReadables", "androidx.test.espresso.util.HumanReadables");
		map.put("android.support.test.espresso.util.TreeIterables", "androidx.test.espresso.util.TreeIterables");
		map.put("android.support.test.espresso.ViewAction", "androidx.test.espresso.ViewAction");
		map.put("android.support.test.espresso.ViewAssertion", "androidx.test.espresso.ViewAssertion");
		map.put("android.support.test.espresso.ViewFinder", "androidx.test.espresso.ViewFinder");
		map.put("android.support.test.espresso.ViewInteraction", "androidx.test.espresso.ViewInteraction");
		map.put("android.support.test.espresso.ViewInteraction_Factory",
				"androidx.test.espresso.ViewInteraction_Factory");
		map.put("android.support.test.espresso.ViewInteractionComponent",
				"androidx.test.espresso.ViewInteractionComponent");
		map.put("android.support.test.espresso.ViewInteractionModule", "androidx.test.espresso.ViewInteractionModule");
		map.put("android.support.test.espresso.ViewInteractionModule_ProvideNeedsActivityFactory",
				"androidx.test.espresso.ViewInteractionModule_ProvideNeedsActivityFactory");
		map.put("android.support.test.espresso.ViewInteractionModule_ProvideRemoteInteractionFactory",
				"androidx.test.espresso.ViewInteractionModule_ProvideRemoteInteractionFactory");
		map.put("android.support.test.espresso.ViewInteractionModule_ProvideRootMatcherFactory",
				"androidx.test.espresso.ViewInteractionModule_ProvideRootMatcherFactory");
		map.put("android.support.test.espresso.ViewInteractionModule_ProvideRootViewFactory",
				"androidx.test.espresso.ViewInteractionModule_ProvideRootViewFactory");
		map.put("android.support.test.espresso.ViewInteractionModule_ProvideViewFinderFactory",
				"androidx.test.espresso.ViewInteractionModule_ProvideViewFinderFactory");
		map.put("android.support.test.espresso.ViewInteractionModule_ProvideViewMatcherFactory",
				"androidx.test.espresso.ViewInteractionModule_ProvideViewMatcherFactory");
		map.put("android.support.test.espresso.web.action.AtomAction", "androidx.test.espresso.web.action.AtomAction");
		map.put("android.support.test.espresso.web.action.AtomActionRemoteMessage",
				"androidx.test.espresso.web.action.AtomActionRemoteMessage");
		map.put("android.support.test.espresso.web.action.EnableJavascriptAction",
				"androidx.test.espresso.web.action.EnableJavascriptAction");
		map.put("android.support.test.espresso.web.action.EvaluationAtom",
				"androidx.test.espresso.web.action.EvaluationAtom");
		map.put("android.support.test.espresso.web.action.IAtomActionResultPropagator",
				"androidx.test.espresso.web.action.IAtomActionResultPropagator");
		map.put("android.support.test.espresso.web.action.JavascriptEvaluation",
				"androidx.test.espresso.web.action.JavascriptEvaluation");
		map.put("android.support.test.espresso.web.action.RemoteWebActions",
				"androidx.test.espresso.web.action.RemoteWebActions");
		map.put("android.support.test.espresso.web.assertion.ByteStringToDocumentConverter",
				"androidx.test.espresso.web.assertion.ByteStringToDocumentConverter");
		map.put("android.support.test.espresso.web.assertion.CheckResultWebAssertionRemoteMessage",
				"androidx.test.espresso.web.assertion.CheckResultWebAssertionRemoteMessage");
		map.put("android.support.test.espresso.web.assertion.CompressorDecompressor",
				"androidx.test.espresso.web.assertion.CompressorDecompressor");
		map.put("android.support.test.espresso.web.assertion.DocumentProtoConverters",
				"androidx.test.espresso.web.assertion.DocumentProtoConverters");
		map.put("android.support.test.espresso.web.assertion.DocumentToByteStringConverter",
				"androidx.test.espresso.web.assertion.DocumentToByteStringConverter");
		map.put("android.support.test.espresso.web.assertion.RemoteWebViewAssertions",
				"androidx.test.espresso.web.assertion.RemoteWebViewAssertions");
		map.put("android.support.test.espresso.web.assertion.TagSoupDocumentParser",
				"androidx.test.espresso.web.assertion.TagSoupDocumentParser");
		map.put("android.support.test.espresso.web.assertion.WebAssertion",
				"androidx.test.espresso.web.assertion.WebAssertion");
		map.put("android.support.test.espresso.web.assertion.WebViewAssertions",
				"androidx.test.espresso.web.assertion.WebViewAssertions");
		map.put("android.support.test.espresso.web.matcher.AmbiguousElementMatcherException",
				"androidx.test.espresso.web.matcher.AmbiguousElementMatcherException");
		map.put("android.support.test.espresso.web.matcher.DomMatchers",
				"androidx.test.espresso.web.matcher.DomMatchers");
		map.put("android.support.test.espresso.web.matcher.RemoteWebMatchers",
				"androidx.test.espresso.web.matcher.RemoteWebMatchers");
		map.put("android.support.test.espresso.web.model.Atom", "androidx.test.espresso.web.model.Atom");
		map.put("android.support.test.espresso.web.model.Atoms", "androidx.test.espresso.web.model.Atoms");
		map.put("android.support.test.espresso.web.model.ElementReference",
				"androidx.test.espresso.web.model.ElementReference");
		map.put("android.support.test.espresso.web.model.Evaluation", "androidx.test.espresso.web.model.Evaluation");
		map.put("android.support.test.espresso.web.model.JSONAble", "androidx.test.espresso.web.model.JSONAble");
		map.put("android.support.test.espresso.web.model.ModelCodec", "androidx.test.espresso.web.model.ModelCodec");
		map.put("android.support.test.espresso.web.model.RemoteWebModelAtoms",
				"androidx.test.espresso.web.model.RemoteWebModelAtoms");
		map.put("android.support.test.espresso.web.model.ScriptWithArgsSimpleAtomRemoteMessage",
				"androidx.test.espresso.web.model.ScriptWithArgsSimpleAtomRemoteMessage");
		map.put("android.support.test.espresso.web.model.SimpleAtom", "androidx.test.espresso.web.model.SimpleAtom");
		map.put("android.support.test.espresso.web.model.TransformingAtom",
				"androidx.test.espresso.web.model.TransformingAtom");
		map.put("android.support.test.espresso.web.model.WindowReference",
				"androidx.test.espresso.web.model.WindowReference");
		map.put("android.support.test.espresso.web.proto.action.WebActions",
				"androidx.test.espresso.web.proto.action.WebActions");
		map.put("android.support.test.espresso.web.proto.assertion.WebAssertions",
				"androidx.test.espresso.web.proto.assertion.WebAssertions");
		map.put("android.support.test.espresso.web.proto.matcher.RemoteWebMatchers",
				"androidx.test.espresso.web.proto.matcher.RemoteWebMatchers");
		map.put("android.support.test.espresso.web.proto.model.WebModelAtoms",
				"androidx.test.espresso.web.proto.model.WebModelAtoms");
		map.put("android.support.test.espresso.web.proto.sugar.WebSugar",
				"androidx.test.espresso.web.proto.sugar.WebSugar");
		map.put("android.support.test.espresso.web.proto.webdriver.WebWebdriverAtoms",
				"androidx.test.espresso.web.proto.webdriver.WebWebdriverAtoms");
		map.put("android.support.test.espresso.web.sugar.RemoteWebSugar",
				"androidx.test.espresso.web.sugar.RemoteWebSugar");
		map.put("android.support.test.espresso.web.sugar.Web", "androidx.test.espresso.web.sugar.Web");
		map.put("android.support.test.espresso.web.webdriver.DriverAtoms",
				"androidx.test.espresso.web.webdriver.DriverAtoms");
		map.put("android.support.test.espresso.web.webdriver.Locator", "androidx.test.espresso.web.webdriver.Locator");
		map.put("android.support.test.espresso.web.webdriver.RemoteWebDriverAtoms",
				"androidx.test.espresso.web.webdriver.RemoteWebDriverAtoms");
		map.put("android.support.test.espresso.web.webdriver.WebDriverAtomScripts",
				"androidx.test.espresso.web.webdriver.WebDriverAtomScripts");
		map.put("android.support.test.filters.FlakyTest", "androidx.test.filters.FlakyTest");
		map.put("android.support.test.filters.LargeTest", "androidx.test.filters.LargeTest");
		map.put("android.support.test.filters.MediumTest", "androidx.test.filters.MediumTest");
		map.put("android.support.test.filters.RequiresDevice", "androidx.test.filters.RequiresDevice");
		map.put("android.support.test.filters.SdkSuppress", "androidx.test.filters.SdkSuppress");
		map.put("android.support.test.filters.SmallTest", "androidx.test.filters.SmallTest");
		map.put("android.support.test.filters.Suppress", "androidx.test.filters.Suppress");
		map.put("android.support.test.InstrumentationRegistry", "androidx.test.InstrumentationRegistry");
		map.put("android.support.test.jank.GfxMonitor", "androidx.test.jank.GfxMonitor");
		map.put("android.support.test.jank.JankTest", "androidx.test.jank.JankTest");
		map.put("android.support.test.jank.JankTestBase", "androidx.test.jank.JankTestBase");
		map.put("android.support.test.jank.WindowAnimationFrameStatsMonitor",
				"androidx.test.jank.WindowAnimationFrameStatsMonitor");
		map.put("android.support.test.jank.WindowContentFrameStatsMonitor",
				"androidx.test.jank.WindowContentFrameStatsMonitor");
		map.put("android.support.test.orchestrator.callback.OrchestratorCallback",
				"androidx.test.orchestrator.callback.OrchestratorCallback");
		map.put("android.support.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener",
				"androidx.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener");
		map.put("android.support.test.orchestrator.junit.BundleJUnitUtils",
				"androidx.test.orchestrator.junit.BundleJUnitUtils");
		map.put("android.support.test.orchestrator.junit.ParcelableDescription",
				"androidx.test.orchestrator.junit.ParcelableDescription");
		map.put("android.support.test.orchestrator.junit.ParcelableFailure",
				"androidx.test.orchestrator.junit.ParcelableFailure");
		map.put("android.support.test.orchestrator.junit.ParcelableResult",
				"androidx.test.orchestrator.junit.ParcelableResult");
		map.put("android.support.test.orchestrator.listeners.OrchestrationListenerManager",
				"androidx.test.orchestrator.listeners.OrchestrationListenerManager");
		map.put("android.support.test.orchestrator.listeners.OrchestrationRunListener",
				"androidx.test.orchestrator.listeners.OrchestrationRunListener");
		map.put("android.support.test.orchestrator.listeners.result.ITestRunListener",
				"androidx.test.orchestrator.listeners.result.ITestRunListener");
		map.put("android.support.test.orchestrator.listeners.result.TestIdentifier",
				"androidx.test.orchestrator.listeners.result.TestIdentifier");
		map.put("android.support.test.orchestrator.listeners.result.TestResult",
				"androidx.test.orchestrator.listeners.result.TestResult");
		map.put("android.support.test.orchestrator.listeners.result.TestRunResult",
				"androidx.test.orchestrator.listeners.result.TestRunResult");
		map.put("android.support.test.rule.ActivityTestRule", "androidx.test.rule.ActivityTestRule");
		map.put("android.support.test.rule.DisableOnAndroidDebug", "androidx.test.rule.DisableOnAndroidDebug");
		map.put("android.support.test.rule.GrantPermissionRule", "androidx.test.rule.GrantPermissionRule");
		map.put("android.support.test.rule.logging.AtraceLogger", "androidx.test.rule.logging.AtraceLogger");
		map.put("android.support.test.rule.PortForwardingRule", "androidx.test.rule.PortForwardingRule");
		map.put("android.support.test.rule.provider.DatabaseArgs", "androidx.test.rule.provider.DatabaseArgs");
		map.put("android.support.test.rule.provider.DelegatingContext",
				"androidx.test.rule.provider.DelegatingContext");
		map.put("android.support.test.rule.provider.ProviderArgs", "androidx.test.rule.provider.ProviderArgs");
		map.put("android.support.test.rule.provider.ProviderTestRule", "androidx.test.rule.provider.ProviderTestRule");
		map.put("android.support.test.rule.ServiceTestRule", "androidx.test.rule.ServiceTestRule");
		map.put("android.support.test.rule.UiThreadTestRule", "androidx.test.rule.UiThreadTestRule");
		map.put("android.support.test.runner.AndroidJUnit4", "androidx.test.runner.AndroidJUnit4");
		map.put("android.support.test.runner.AndroidJUnitRunner", "androidx.test.runner.AndroidJUnitRunner");
		map.put("android.support.test.runner.intent.IntentCallback", "androidx.test.runner.intent.IntentCallback");
		map.put("android.support.test.runner.intent.IntentMonitor", "androidx.test.runner.intent.IntentMonitor");
		map.put("android.support.test.runner.intent.IntentMonitorRegistry",
				"androidx.test.runner.intent.IntentMonitorRegistry");
		map.put("android.support.test.runner.intent.IntentStubber", "androidx.test.runner.intent.IntentStubber");
		map.put("android.support.test.runner.intent.IntentStubberRegistry",
				"androidx.test.runner.intent.IntentStubberRegistry");
		map.put("android.support.test.runner.intercepting.InterceptingActivityFactory",
				"androidx.test.runner.intercepting.InterceptingActivityFactory");
		map.put("android.support.test.runner.intercepting.SingleActivityFactory",
				"androidx.test.runner.intercepting.SingleActivityFactory");
		map.put("android.support.test.runner.lifecycle.ActivityLifecycleCallback",
				"androidx.test.runner.lifecycle.ActivityLifecycleCallback");
		map.put("android.support.test.runner.lifecycle.ActivityLifecycleMonitor",
				"androidx.test.runner.lifecycle.ActivityLifecycleMonitor");
		map.put("android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry",
				"androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry");
		map.put("android.support.test.runner.lifecycle.ApplicationLifecycleCallback",
				"androidx.test.runner.lifecycle.ApplicationLifecycleCallback");
		map.put("android.support.test.runner.lifecycle.ApplicationLifecycleMonitor",
				"androidx.test.runner.lifecycle.ApplicationLifecycleMonitor");
		map.put("android.support.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry",
				"androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry");
		map.put("android.support.test.runner.lifecycle.ApplicationStage",
				"androidx.test.runner.lifecycle.ApplicationStage");
		map.put("android.support.test.runner.lifecycle.Stage", "androidx.test.runner.lifecycle.Stage");
		map.put("android.support.test.runner.MonitoringInstrumentation",
				"androidx.test.runner.MonitoringInstrumentation");
		map.put("android.support.test.runner.permission.GrantPermissionCallable",
				"androidx.test.runner.permission.GrantPermissionCallable");
		map.put("android.support.test.runner.permission.PermissionRequester",
				"androidx.test.runner.permission.PermissionRequester");
		map.put("android.support.test.runner.permission.RequestPermissionCallable",
				"androidx.test.runner.permission.RequestPermissionCallable");
		map.put("android.support.test.runner.permission.ShellCommand", "androidx.test.runner.permission.ShellCommand");
		map.put("android.support.test.runner.permission.UiAutomationShellCommand",
				"androidx.test.runner.permission.UiAutomationShellCommand");
		map.put("android.support.test.runner.screenshot.BasicScreenCaptureProcessor",
				"androidx.test.runner.screenshot.BasicScreenCaptureProcessor");
		map.put("android.support.test.runner.screenshot.ScreenCapture",
				"androidx.test.runner.screenshot.ScreenCapture");
		map.put("android.support.test.runner.screenshot.ScreenCaptureProcessor",
				"androidx.test.runner.screenshot.ScreenCaptureProcessor");
		map.put("android.support.test.runner.screenshot.Screenshot", "androidx.test.runner.screenshot.Screenshot");
		map.put("android.support.test.runner.screenshot.TakeScreenshotCallable",
				"androidx.test.runner.screenshot.TakeScreenshotCallable");
		map.put("android.support.test.runner.screenshot.UiAutomationWrapper",
				"androidx.test.runner.screenshot.UiAutomationWrapper");
		map.put("android.support.test.runner.UsageTrackerFacilitator", "androidx.test.runner.UsageTrackerFacilitator");
		map.put("android.support.test.uiautomator.AccessibilityNodeInfoDumper",
				"androidx.test.uiautomator.AccessibilityNodeInfoDumper");
		map.put("android.support.test.uiautomator.AccessibilityNodeInfoHelper",
				"androidx.test.uiautomator.AccessibilityNodeInfoHelper");
		map.put("android.support.test.uiautomator.By", "androidx.test.uiautomator.By");
		map.put("android.support.test.uiautomator.ByMatcher", "androidx.test.uiautomator.ByMatcher");
		map.put("android.support.test.uiautomator.BySelector", "androidx.test.uiautomator.BySelector");
		map.put("android.support.test.uiautomator.Condition", "androidx.test.uiautomator.Condition");
		map.put("android.support.test.uiautomator.Configurator", "androidx.test.uiautomator.Configurator");
		map.put("android.support.test.uiautomator.Direction", "androidx.test.uiautomator.Direction");
		map.put("android.support.test.uiautomator.EventCondition", "androidx.test.uiautomator.EventCondition");
		map.put("android.support.test.uiautomator.GestureController", "androidx.test.uiautomator.GestureController");
		map.put("android.support.test.uiautomator.Gestures", "androidx.test.uiautomator.Gestures");
		map.put("android.support.test.uiautomator.IAutomationSupport", "androidx.test.uiautomator.IAutomationSupport");
		map.put("android.support.test.uiautomator.InstrumentationAutomationSupport",
				"androidx.test.uiautomator.InstrumentationAutomationSupport");
		map.put("android.support.test.uiautomator.InteractionController",
				"androidx.test.uiautomator.InteractionController");
		map.put("android.support.test.uiautomator.PointerGesture", "androidx.test.uiautomator.PointerGesture");
		map.put("android.support.test.uiautomator.QueryController", "androidx.test.uiautomator.QueryController");
		map.put("android.support.test.uiautomator.Searchable", "androidx.test.uiautomator.Searchable");
		map.put("android.support.test.uiautomator.SearchCondition", "androidx.test.uiautomator.SearchCondition");
		map.put("android.support.test.uiautomator.StaleObjectException",
				"androidx.test.uiautomator.StaleObjectException");
		map.put("android.support.test.uiautomator.Tracer", "androidx.test.uiautomator.Tracer");
		map.put("android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner",
				"androidx.test.uiautomator.UiAutomatorInstrumentationTestRunner");
		map.put("android.support.test.uiautomator.UiAutomatorTestCase",
				"androidx.test.uiautomator.UiAutomatorTestCase");
		map.put("android.support.test.uiautomator.UiCollection", "androidx.test.uiautomator.UiCollection");
		map.put("android.support.test.uiautomator.UiDevice", "androidx.test.uiautomator.UiDevice");
		map.put("android.support.test.uiautomator.UiObject", "androidx.test.uiautomator.UiObject");
		map.put("android.support.test.uiautomator.UiObject2", "androidx.test.uiautomator.UiObject2");
		map.put("android.support.test.uiautomator.UiObject2Condition", "androidx.test.uiautomator.UiObject2Condition");
		map.put("android.support.test.uiautomator.UiObjectNotFoundException",
				"androidx.test.uiautomator.UiObjectNotFoundException");
		map.put("android.support.test.uiautomator.UiScrollable", "androidx.test.uiautomator.UiScrollable");
		map.put("android.support.test.uiautomator.UiSelector", "androidx.test.uiautomator.UiSelector");
		map.put("android.support.test.uiautomator.UiWatcher", "androidx.test.uiautomator.UiWatcher");
		map.put("android.support.test.uiautomator.Until", "androidx.test.uiautomator.Until");
		map.put("android.support.test.uiautomator.WaitMixin", "androidx.test.uiautomator.WaitMixin");
		map.put("android.support.text.emoji.bundled.BundledEmojiCompatConfig",
				"androidx.emoji.bundled.BundledEmojiCompatConfig");
		map.put("android.support.text.emoji.EmojiCompat", "androidx.emoji.text.EmojiCompat");
		map.put("android.support.text.emoji.EmojiMetadata", "androidx.emoji.text.EmojiMetadata");
		map.put("android.support.text.emoji.EmojiProcessor", "androidx.emoji.text.EmojiProcessor");
		map.put("android.support.text.emoji.EmojiSpan", "androidx.emoji.text.EmojiSpan");
		map.put("android.support.text.emoji.FontRequestEmojiCompatConfig",
				"androidx.emoji.text.FontRequestEmojiCompatConfig");
		map.put("android.support.text.emoji.MetadataListReader", "androidx.emoji.text.MetadataListReader");
		map.put("android.support.text.emoji.MetadataRepo", "androidx.emoji.text.MetadataRepo");
		map.put("android.support.text.emoji.R", "androidx.emoji.R");
		map.put("android.support.text.emoji.TypefaceEmojiSpan", "androidx.emoji.text.TypefaceEmojiSpan");
		map.put("android.support.text.emoji.widget.EditTextAttributeHelper",
				"androidx.emoji.widget.EditTextAttributeHelper");
		map.put("android.support.text.emoji.widget.EmojiAppCompatButton", "androidx.emoji.widget.EmojiAppCompatButton");
		map.put("android.support.text.emoji.widget.EmojiAppCompatEditText",
				"androidx.emoji.widget.EmojiAppCompatEditText");
		map.put("android.support.text.emoji.widget.EmojiAppCompatTextView",
				"androidx.emoji.widget.EmojiAppCompatTextView");
		map.put("android.support.text.emoji.widget.EmojiButton", "androidx.emoji.widget.EmojiButton");
		map.put("android.support.text.emoji.widget.EmojiEditableFactory", "androidx.emoji.widget.EmojiEditableFactory");
		map.put("android.support.text.emoji.widget.EmojiEditText", "androidx.emoji.widget.EmojiEditText");
		map.put("android.support.text.emoji.widget.EmojiEditTextHelper", "androidx.emoji.widget.EmojiEditTextHelper");
		map.put("android.support.text.emoji.widget.EmojiExtractEditText", "androidx.emoji.widget.EmojiExtractEditText");
		map.put("android.support.text.emoji.widget.EmojiExtractTextLayout",
				"androidx.emoji.widget.EmojiExtractTextLayout");
		map.put("android.support.text.emoji.widget.EmojiInputConnection", "androidx.emoji.widget.EmojiInputConnection");
		map.put("android.support.text.emoji.widget.EmojiInputFilter", "androidx.emoji.widget.EmojiInputFilter");
		map.put("android.support.text.emoji.widget.EmojiKeyListener", "androidx.emoji.widget.EmojiKeyListener");
		map.put("android.support.text.emoji.widget.EmojiTextView", "androidx.emoji.widget.EmojiTextView");
		map.put("android.support.text.emoji.widget.EmojiTextViewHelper", "androidx.emoji.widget.EmojiTextViewHelper");
		map.put("android.support.text.emoji.widget.EmojiTextWatcher", "androidx.emoji.widget.EmojiTextWatcher");
		map.put("android.support.text.emoji.widget.EmojiTransformationMethod",
				"androidx.emoji.widget.EmojiTransformationMethod");
		map.put("android.support.text.emoji.widget.ExtractButtonCompat", "androidx.emoji.widget.ExtractButtonCompat");
		map.put("android.support.text.emoji.widget.SpannableBuilder", "androidx.emoji.widget.SpannableBuilder");
		map.put("android.support.transition.AnimatorUtils", "androidx.transition.AnimatorUtils");
		map.put("android.support.transition.ArcMotion", "androidx.transition.ArcMotion");
		map.put("android.support.transition.AutoTransition", "androidx.transition.AutoTransition");
		map.put("android.support.transition.ChangeBounds", "androidx.transition.ChangeBounds");
		map.put("android.support.transition.ChangeClipBounds", "androidx.transition.ChangeClipBounds");
		map.put("android.support.transition.ChangeImageTransform", "androidx.transition.ChangeImageTransform");
		map.put("android.support.transition.ChangeScroll", "androidx.transition.ChangeScroll");
		map.put("android.support.transition.ChangeTransform", "androidx.transition.ChangeTransform");
		map.put("android.support.transition.CircularPropagation", "androidx.transition.CircularPropagation");
		map.put("android.support.transition.Explode", "androidx.transition.Explode");
		map.put("android.support.transition.Fade", "androidx.transition.Fade");
		map.put("android.support.transition.FloatArrayEvaluator", "androidx.transition.FloatArrayEvaluator");
		map.put("android.support.transition.FragmentTransitionSupport",
				"androidx.transition.FragmentTransitionSupport");
		map.put("android.support.transition.GhostViewApi14", "androidx.transition.GhostViewApi14");
		map.put("android.support.transition.GhostViewApi21", "androidx.transition.GhostViewApi21");
		map.put("android.support.transition.GhostViewImpl", "androidx.transition.GhostViewImpl");
		map.put("android.support.transition.GhostViewUtils", "androidx.transition.GhostViewUtils");
		map.put("android.support.transition.ImageViewUtils", "androidx.transition.ImageViewUtils");
		map.put("android.support.transition.MatrixUtils", "androidx.transition.MatrixUtils");
		map.put("android.support.transition.ObjectAnimatorUtils", "androidx.transition.ObjectAnimatorUtils");
		map.put("android.support.transition.PathMotion", "androidx.transition.PathMotion");
		map.put("android.support.transition.PathProperty", "androidx.transition.PathProperty");
		map.put("android.support.transition.PatternPathMotion", "androidx.transition.PatternPathMotion");
		map.put("android.support.transition.PropertyValuesHolderUtils",
				"androidx.transition.PropertyValuesHolderUtils");
		map.put("android.support.transition.R", "androidx.transition.R");
		map.put("android.support.transition.RectEvaluator", "androidx.transition.RectEvaluator");
		map.put("android.support.transition.Scene", "androidx.transition.Scene");
		map.put("android.support.transition.SidePropagation", "androidx.transition.SidePropagation");
		map.put("android.support.transition.Slide", "androidx.transition.Slide");
		map.put("android.support.transition.Styleable", "androidx.transition.Styleable");
		map.put("android.support.transition.Transition", "androidx.transition.Transition");
		map.put("android.support.transition.TransitionInflater", "androidx.transition.TransitionInflater");
		map.put("android.support.transition.TransitionListenerAdapter",
				"androidx.transition.TransitionListenerAdapter");
		map.put("android.support.transition.TransitionManager", "androidx.transition.TransitionManager");
		map.put("android.support.transition.TransitionPropagation", "androidx.transition.TransitionPropagation");
		map.put("android.support.transition.TransitionSet", "androidx.transition.TransitionSet");
		map.put("android.support.transition.TransitionUtils", "androidx.transition.TransitionUtils");
		map.put("android.support.transition.TransitionValues", "androidx.transition.TransitionValues");
		map.put("android.support.transition.TransitionValuesMaps", "androidx.transition.TransitionValuesMaps");
		map.put("android.support.transition.TranslationAnimationCreator",
				"androidx.transition.TranslationAnimationCreator");
		map.put("android.support.transition.ViewGroupOverlayApi14", "androidx.transition.ViewGroupOverlayApi14");
		map.put("android.support.transition.ViewGroupOverlayApi18", "androidx.transition.ViewGroupOverlayApi18");
		map.put("android.support.transition.ViewGroupOverlayImpl", "androidx.transition.ViewGroupOverlayImpl");
		map.put("android.support.transition.ViewGroupUtils", "androidx.transition.ViewGroupUtils");
		map.put("android.support.transition.ViewGroupUtilsApi14", "androidx.transition.ViewGroupUtilsApi14");
		map.put("android.support.transition.ViewGroupUtilsApi18", "androidx.transition.ViewGroupUtilsApi18");
		map.put("android.support.transition.ViewOverlayApi14", "androidx.transition.ViewOverlayApi14");
		map.put("android.support.transition.ViewOverlayApi18", "androidx.transition.ViewOverlayApi18");
		map.put("android.support.transition.ViewOverlayImpl", "androidx.transition.ViewOverlayImpl");
		map.put("android.support.transition.ViewUtils", "androidx.transition.ViewUtils");
		map.put("android.support.transition.ViewUtilsApi19", "androidx.transition.ViewUtilsApi19");
		map.put("android.support.transition.ViewUtilsApi21", "androidx.transition.ViewUtilsApi21");
		map.put("android.support.transition.ViewUtilsApi22", "androidx.transition.ViewUtilsApi22");
		map.put("android.support.transition.ViewUtilsBase", "androidx.transition.ViewUtilsBase");
		map.put("android.support.transition.Visibility", "androidx.transition.Visibility");
		map.put("android.support.transition.VisibilityPropagation", "androidx.transition.VisibilityPropagation");
		map.put("android.support.transition.WindowIdApi14", "androidx.transition.WindowIdApi14");
		map.put("android.support.transition.WindowIdApi18", "androidx.transition.WindowIdApi18");
		map.put("android.support.transition.WindowIdImpl", "androidx.transition.WindowIdImpl");
		map.put("android.support.v13.app.ActivityCompat", "androidx.legacy.app.ActivityCompat");
		map.put("android.support.v13.app.FragmentCompat", "androidx.legacy.app.FragmentCompat");
		map.put("android.support.v13.app.FragmentPagerAdapter", "androidx.legacy.app.FragmentPagerAdapter");
		map.put("android.support.v13.app.FragmentStatePagerAdapter", "androidx.legacy.app.FragmentStatePagerAdapter");
		map.put("android.support.v13.app.FragmentTabHost", "androidx.legacy.app.FragmentTabHost");
		map.put("android.support.v13.view.DragAndDropPermissionsCompat",
				"androidx.core.view.DragAndDropPermissionsCompat");
		map.put("android.support.v13.view.DragStartHelper", "androidx.core.view.DragStartHelper");
		map.put("android.support.v13.view.inputmethod.EditorInfoCompat",
				"androidx.core.view.inputmethod.EditorInfoCompat");
		map.put("android.support.v13.view.inputmethod.InputConnectionCompat",
				"androidx.core.view.inputmethod.InputConnectionCompat");
		map.put("android.support.v13.view.inputmethod.InputContentInfoCompat",
				"androidx.core.view.inputmethod.InputContentInfoCompat");
		map.put("android.support.v13.view.ViewCompat", "androidx.legacy.view.ViewCompat");
		map.put("android.support.v14.preference.EditTextPreferenceDialogFragment",
				"androidx.preference.EditTextPreferenceDialogFragment");
		map.put("android.support.v14.preference.ListPreferenceDialogFragment",
				"androidx.preference.ListPreferenceDialogFragment");
		map.put("android.support.v14.preference.MultiSelectListPreference",
				"androidx.preference.MultiSelectListPreference");
		map.put("android.support.v14.preference.MultiSelectListPreferenceDialogFragment",
				"androidx.preference.MultiSelectListPreferenceDialogFragment");
		map.put("android.support.v14.preference.PreferenceDialogFragment",
				"androidx.preference.PreferenceDialogFragment");
		map.put("android.support.v14.preference.PreferenceFragment", "androidx.preference.PreferenceFragment");
		map.put("android.support.v14.preference.SwitchPreference", "androidx.preference.SwitchPreference");
		map.put("android.support.v17.internal.widget.OutlineOnlyWithChildrenFrameLayout",
				"androidx.leanback.preference.internal.OutlineOnlyWithChildrenFrameLayout");
		map.put("android.support.v17.leanback.animation.LogAccelerateInterpolator",
				"androidx.leanback.animation.LogAccelerateInterpolator");
		map.put("android.support.v17.leanback.animation.LogDecelerateInterpolator",
				"androidx.leanback.animation.LogDecelerateInterpolator");
		map.put("android.support.v17.leanback.app.BackgroundFragment", "androidx.leanback.app.BackgroundFragment");
		map.put("android.support.v17.leanback.app.BackgroundManager", "androidx.leanback.app.BackgroundManager");
		map.put("android.support.v17.leanback.app.BaseFragment", "androidx.leanback.app.BaseFragment");
		map.put("android.support.v17.leanback.app.BaseRowFragment", "androidx.leanback.app.BaseRowFragment");
		map.put("android.support.v17.leanback.app.BaseRowSupportFragment",
				"androidx.leanback.app.BaseRowSupportFragment");
		map.put("android.support.v17.leanback.app.BaseSupportFragment", "androidx.leanback.app.BaseSupportFragment");
		map.put("android.support.v17.leanback.app.BrandedFragment", "androidx.leanback.app.BrandedFragment");
		map.put("android.support.v17.leanback.app.BrandedSupportFragment",
				"androidx.leanback.app.BrandedSupportFragment");
		map.put("android.support.v17.leanback.app.BrowseFragment", "androidx.leanback.app.BrowseFragment");
		map.put("android.support.v17.leanback.app.BrowseSupportFragment",
				"androidx.leanback.app.BrowseSupportFragment");
		map.put("android.support.v17.leanback.app.DetailsBackgroundVideoHelper",
				"androidx.leanback.app.DetailsBackgroundVideoHelper");
		map.put("android.support.v17.leanback.app.DetailsFragment", "androidx.leanback.app.DetailsFragment");
		map.put("android.support.v17.leanback.app.DetailsFragmentBackgroundController",
				"androidx.leanback.app.DetailsFragmentBackgroundController");
		map.put("android.support.v17.leanback.app.DetailsSupportFragment",
				"androidx.leanback.app.DetailsSupportFragment");
		map.put("android.support.v17.leanback.app.DetailsSupportFragmentBackgroundController",
				"androidx.leanback.app.DetailsSupportFragmentBackgroundController");
		map.put("android.support.v17.leanback.app.ErrorFragment", "androidx.leanback.app.ErrorFragment");
		map.put("android.support.v17.leanback.app.ErrorSupportFragment", "androidx.leanback.app.ErrorSupportFragment");
		map.put("android.support.v17.leanback.app.FragmentUtil", "androidx.leanback.app.FragmentUtil");
		map.put("android.support.v17.leanback.app.GuidedStepFragment", "androidx.leanback.app.GuidedStepFragment");
		map.put("android.support.v17.leanback.app.GuidedStepRootLayout", "androidx.leanback.app.GuidedStepRootLayout");
		map.put("android.support.v17.leanback.app.GuidedStepSupportFragment",
				"androidx.leanback.app.GuidedStepSupportFragment");
		map.put("android.support.v17.leanback.app.HeadersFragment", "androidx.leanback.app.HeadersFragment");
		map.put("android.support.v17.leanback.app.HeadersSupportFragment",
				"androidx.leanback.app.HeadersSupportFragment");
		map.put("android.support.v17.leanback.app.ListRowDataAdapter", "androidx.leanback.app.ListRowDataAdapter");
		map.put("android.support.v17.leanback.app.OnboardingFragment", "androidx.leanback.app.OnboardingFragment");
		map.put("android.support.v17.leanback.app.OnboardingSupportFragment",
				"androidx.leanback.app.OnboardingSupportFragment");
		map.put("android.support.v17.leanback.app.PermissionHelper", "androidx.leanback.app.PermissionHelper");
		map.put("android.support.v17.leanback.app.PlaybackFragment", "androidx.leanback.app.PlaybackFragment");
		map.put("android.support.v17.leanback.app.PlaybackFragmentGlueHost",
				"androidx.leanback.app.PlaybackFragmentGlueHost");
		map.put("android.support.v17.leanback.app.PlaybackSupportFragment",
				"androidx.leanback.app.PlaybackSupportFragment");
		map.put("android.support.v17.leanback.app.PlaybackSupportFragmentGlueHost",
				"androidx.leanback.app.PlaybackSupportFragmentGlueHost");
		map.put("android.support.v17.leanback.app.ProgressBarManager", "androidx.leanback.app.ProgressBarManager");
		map.put("android.support.v17.leanback.app.RowsFragment", "androidx.leanback.app.RowsFragment");
		map.put("android.support.v17.leanback.app.RowsSupportFragment", "androidx.leanback.app.RowsSupportFragment");
		map.put("android.support.v17.leanback.app.SearchFragment", "androidx.leanback.app.SearchFragment");
		map.put("android.support.v17.leanback.app.SearchSupportFragment",
				"androidx.leanback.app.SearchSupportFragment");
		map.put("android.support.v17.leanback.app.VerticalGridFragment", "androidx.leanback.app.VerticalGridFragment");
		map.put("android.support.v17.leanback.app.VerticalGridSupportFragment",
				"androidx.leanback.app.VerticalGridSupportFragment");
		map.put("android.support.v17.leanback.app.VideoFragment", "androidx.leanback.app.VideoFragment");
		map.put("android.support.v17.leanback.app.VideoFragmentGlueHost",
				"androidx.leanback.app.VideoFragmentGlueHost");
		map.put("android.support.v17.leanback.app.VideoSupportFragment", "androidx.leanback.app.VideoSupportFragment");
		map.put("android.support.v17.leanback.app.VideoSupportFragmentGlueHost",
				"androidx.leanback.app.VideoSupportFragmentGlueHost");
		map.put("android.support.v17.leanback.database.CursorMapper", "androidx.leanback.database.CursorMapper");
		map.put("android.support.v17.leanback.graphics.BoundsRule", "androidx.leanback.graphics.BoundsRule");
		map.put("android.support.v17.leanback.graphics.ColorFilterCache",
				"androidx.leanback.graphics.ColorFilterCache");
		map.put("android.support.v17.leanback.graphics.ColorFilterDimmer",
				"androidx.leanback.graphics.ColorFilterDimmer");
		map.put("android.support.v17.leanback.graphics.ColorOverlayDimmer",
				"androidx.leanback.graphics.ColorOverlayDimmer");
		map.put("android.support.v17.leanback.graphics.CompositeDrawable",
				"androidx.leanback.graphics.CompositeDrawable");
		map.put("android.support.v17.leanback.graphics.FitWidthBitmapDrawable",
				"androidx.leanback.graphics.FitWidthBitmapDrawable");
		map.put("android.support.v17.leanback.media.MediaControllerAdapter",
				"androidx.leanback.media.MediaControllerAdapter");
		map.put("android.support.v17.leanback.media.MediaControllerGlue",
				"androidx.leanback.media.MediaControllerGlue");
		map.put("android.support.v17.leanback.media.MediaPlayerAdapter", "androidx.leanback.media.MediaPlayerAdapter");
		map.put("android.support.v17.leanback.media.MediaPlayerGlue", "androidx.leanback.media.MediaPlayerGlue");
		map.put("android.support.v17.leanback.media.PlaybackBannerControlGlue",
				"androidx.leanback.media.PlaybackBannerControlGlue");
		map.put("android.support.v17.leanback.media.PlaybackBaseControlGlue",
				"androidx.leanback.media.PlaybackBaseControlGlue");
		map.put("android.support.v17.leanback.media.PlaybackControlGlue",
				"androidx.leanback.media.PlaybackControlGlue");
		map.put("android.support.v17.leanback.media.PlaybackGlue", "androidx.leanback.media.PlaybackGlue");
		map.put("android.support.v17.leanback.media.PlaybackGlueHost", "androidx.leanback.media.PlaybackGlueHost");
		map.put("android.support.v17.leanback.media.PlaybackTransportControlGlue",
				"androidx.leanback.media.PlaybackTransportControlGlue");
		map.put("android.support.v17.leanback.media.PlayerAdapter", "androidx.leanback.media.PlayerAdapter");
		map.put("android.support.v17.leanback.media.SurfaceHolderGlueHost",
				"androidx.leanback.media.SurfaceHolderGlueHost");
		map.put("android.support.v17.leanback.R", "androidx.leanback.R");
		map.put("android.support.v17.leanback.system.Settings", "androidx.leanback.system.Settings");
		map.put("android.support.v17.leanback.transition.CustomChangeBounds",
				"androidx.leanback.transition.CustomChangeBounds");
		map.put("android.support.v17.leanback.transition.FadeAndShortSlide",
				"androidx.leanback.transition.FadeAndShortSlide");
		map.put("android.support.v17.leanback.transition.LeanbackTransitionHelper",
				"androidx.leanback.transition.LeanbackTransitionHelper");
		map.put("android.support.v17.leanback.transition.ParallaxTransition",
				"androidx.leanback.transition.ParallaxTransition");
		map.put("android.support.v17.leanback.transition.Scale", "androidx.leanback.transition.Scale");
		map.put("android.support.v17.leanback.transition.SlideKitkat", "androidx.leanback.transition.SlideKitkat");
		map.put("android.support.v17.leanback.transition.SlideNoPropagation",
				"androidx.leanback.transition.SlideNoPropagation");
		map.put("android.support.v17.leanback.transition.TransitionEpicenterCallback",
				"androidx.leanback.transition.TransitionEpicenterCallback");
		map.put("android.support.v17.leanback.transition.TransitionHelper",
				"androidx.leanback.transition.TransitionHelper");
		map.put("android.support.v17.leanback.transition.TransitionListener",
				"androidx.leanback.transition.TransitionListener");
		map.put("android.support.v17.leanback.transition.TranslationAnimationCreator",
				"androidx.leanback.transition.TranslationAnimationCreator");
		map.put("android.support.v17.leanback.util.MathUtil", "androidx.leanback.util.MathUtil");
		map.put("android.support.v17.leanback.util.StateMachine", "androidx.leanback.util.StateMachine");
		map.put("android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter",
				"androidx.leanback.widget.AbstractDetailsDescriptionPresenter");
		map.put("android.support.v17.leanback.widget.AbstractMediaItemPresenter",
				"androidx.leanback.widget.AbstractMediaItemPresenter");
		map.put("android.support.v17.leanback.widget.AbstractMediaListHeaderPresenter",
				"androidx.leanback.widget.AbstractMediaListHeaderPresenter");
		map.put("android.support.v17.leanback.widget.Action", "androidx.leanback.widget.Action");
		map.put("android.support.v17.leanback.widget.ActionPresenterSelector",
				"androidx.leanback.widget.ActionPresenterSelector");
		map.put("android.support.v17.leanback.widget.ArrayObjectAdapter",
				"androidx.leanback.widget.ArrayObjectAdapter");
		map.put("android.support.v17.leanback.widget.BackgroundHelper", "androidx.leanback.widget.BackgroundHelper");
		map.put("android.support.v17.leanback.widget.BaseCardView", "androidx.leanback.widget.BaseCardView");
		map.put("android.support.v17.leanback.widget.BaseGridView", "androidx.leanback.widget.BaseGridView");
		map.put("android.support.v17.leanback.widget.BaseOnItemViewClickedListener",
				"androidx.leanback.widget.BaseOnItemViewClickedListener");
		map.put("android.support.v17.leanback.widget.BaseOnItemViewSelectedListener",
				"androidx.leanback.widget.BaseOnItemViewSelectedListener");
		map.put("android.support.v17.leanback.widget.BrowseFrameLayout", "androidx.leanback.widget.BrowseFrameLayout");
		map.put("android.support.v17.leanback.widget.BrowseRowsFrameLayout",
				"androidx.leanback.widget.BrowseRowsFrameLayout");
		map.put("android.support.v17.leanback.widget.CheckableImageView",
				"androidx.leanback.widget.CheckableImageView");
		map.put("android.support.v17.leanback.widget.ClassPresenterSelector",
				"androidx.leanback.widget.ClassPresenterSelector");
		map.put("android.support.v17.leanback.widget.ControlBar", "androidx.leanback.widget.ControlBar");
		map.put("android.support.v17.leanback.widget.ControlBarPresenter",
				"androidx.leanback.widget.ControlBarPresenter");
		map.put("android.support.v17.leanback.widget.ControlButtonPresenterSelector",
				"androidx.leanback.widget.ControlButtonPresenterSelector");
		map.put("android.support.v17.leanback.widget.CursorObjectAdapter",
				"androidx.leanback.widget.CursorObjectAdapter");
		map.put("android.support.v17.leanback.widget.DetailsOverviewLogoPresenter",
				"androidx.leanback.widget.DetailsOverviewLogoPresenter");
		map.put("android.support.v17.leanback.widget.DetailsOverviewRow",
				"androidx.leanback.widget.DetailsOverviewRow");
		map.put("android.support.v17.leanback.widget.DetailsOverviewRowPresenter",
				"androidx.leanback.widget.DetailsOverviewRowPresenter");
		map.put("android.support.v17.leanback.widget.DetailsOverviewSharedElementHelper",
				"androidx.leanback.widget.DetailsOverviewSharedElementHelper");
		map.put("android.support.v17.leanback.widget.DetailsParallax", "androidx.leanback.widget.DetailsParallax");
		map.put("android.support.v17.leanback.widget.DetailsParallaxDrawable",
				"androidx.leanback.widget.DetailsParallaxDrawable");
		map.put("android.support.v17.leanback.widget.DiffCallback", "androidx.leanback.widget.DiffCallback");
		map.put("android.support.v17.leanback.widget.DividerPresenter", "androidx.leanback.widget.DividerPresenter");
		map.put("android.support.v17.leanback.widget.DividerRow", "androidx.leanback.widget.DividerRow");
		map.put("android.support.v17.leanback.widget.FacetProvider", "androidx.leanback.widget.FacetProvider");
		map.put("android.support.v17.leanback.widget.FacetProviderAdapter",
				"androidx.leanback.widget.FacetProviderAdapter");
		map.put("android.support.v17.leanback.widget.FocusHighlight", "androidx.leanback.widget.FocusHighlight");
		map.put("android.support.v17.leanback.widget.FocusHighlightHandler",
				"androidx.leanback.widget.FocusHighlightHandler");
		map.put("android.support.v17.leanback.widget.FocusHighlightHelper",
				"androidx.leanback.widget.FocusHighlightHelper");
		map.put("android.support.v17.leanback.widget.ForegroundHelper", "androidx.leanback.widget.ForegroundHelper");
		map.put("android.support.v17.leanback.widget.FragmentAnimationProvider",
				"androidx.leanback.widget.FragmentAnimationProvider");
		map.put("android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter",
				"androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter");
		map.put("android.support.v17.leanback.widget.FullWidthDetailsOverviewSharedElementHelper",
				"androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper");
		map.put("android.support.v17.leanback.widget.Grid", "androidx.leanback.widget.Grid");
		map.put("android.support.v17.leanback.widget.GridLayoutManager", "androidx.leanback.widget.GridLayoutManager");
		map.put("android.support.v17.leanback.widget.GuidanceStylingRelativeLayout",
				"androidx.leanback.widget.GuidanceStylingRelativeLayout");
		map.put("android.support.v17.leanback.widget.GuidanceStylist", "androidx.leanback.widget.GuidanceStylist");
		map.put("android.support.v17.leanback.widget.GuidedAction", "androidx.leanback.widget.GuidedAction");
		map.put("android.support.v17.leanback.widget.GuidedActionAdapter",
				"androidx.leanback.widget.GuidedActionAdapter");
		map.put("android.support.v17.leanback.widget.GuidedActionAdapterGroup",
				"androidx.leanback.widget.GuidedActionAdapterGroup");
		map.put("android.support.v17.leanback.widget.GuidedActionAutofillSupport",
				"androidx.leanback.widget.GuidedActionAutofillSupport");
		map.put("android.support.v17.leanback.widget.GuidedActionDiffCallback",
				"androidx.leanback.widget.GuidedActionDiffCallback");
		map.put("android.support.v17.leanback.widget.GuidedActionEditText",
				"androidx.leanback.widget.GuidedActionEditText");
		map.put("android.support.v17.leanback.widget.GuidedActionItemContainer",
				"androidx.leanback.widget.GuidedActionItemContainer");
		map.put("android.support.v17.leanback.widget.GuidedActionsRelativeLayout",
				"androidx.leanback.widget.GuidedActionsRelativeLayout");
		map.put("android.support.v17.leanback.widget.GuidedActionsStylist",
				"androidx.leanback.widget.GuidedActionsStylist");
		map.put("android.support.v17.leanback.widget.GuidedDatePickerAction",
				"androidx.leanback.widget.GuidedDatePickerAction");
		map.put("android.support.v17.leanback.widget.HeaderItem", "androidx.leanback.widget.HeaderItem");
		map.put("android.support.v17.leanback.widget.HorizontalGridView",
				"androidx.leanback.widget.HorizontalGridView");
		map.put("android.support.v17.leanback.widget.HorizontalHoverCardSwitcher",
				"androidx.leanback.widget.HorizontalHoverCardSwitcher");
		map.put("android.support.v17.leanback.widget.ImageCardView", "androidx.leanback.widget.ImageCardView");
		map.put("android.support.v17.leanback.widget.ImeKeyMonitor", "androidx.leanback.widget.ImeKeyMonitor");
		map.put("android.support.v17.leanback.widget.InvisibleRowPresenter",
				"androidx.leanback.widget.InvisibleRowPresenter");
		map.put("android.support.v17.leanback.widget.ItemAlignment", "androidx.leanback.widget.ItemAlignment");
		map.put("android.support.v17.leanback.widget.ItemAlignmentFacet",
				"androidx.leanback.widget.ItemAlignmentFacet");
		map.put("android.support.v17.leanback.widget.ItemAlignmentFacetHelper",
				"androidx.leanback.widget.ItemAlignmentFacetHelper");
		map.put("android.support.v17.leanback.widget.ItemBridgeAdapter", "androidx.leanback.widget.ItemBridgeAdapter");
		map.put("android.support.v17.leanback.widget.ItemBridgeAdapterShadowOverlayWrapper",
				"androidx.leanback.widget.ItemBridgeAdapterShadowOverlayWrapper");
		map.put("android.support.v17.leanback.widget.ListRow", "androidx.leanback.widget.ListRow");
		map.put("android.support.v17.leanback.widget.ListRowHoverCardView",
				"androidx.leanback.widget.ListRowHoverCardView");
		map.put("android.support.v17.leanback.widget.ListRowPresenter", "androidx.leanback.widget.ListRowPresenter");
		map.put("android.support.v17.leanback.widget.ListRowView", "androidx.leanback.widget.ListRowView");
		map.put("android.support.v17.leanback.widget.MediaItemActionPresenter",
				"androidx.leanback.widget.MediaItemActionPresenter");
		map.put("android.support.v17.leanback.widget.MediaNowPlayingView",
				"androidx.leanback.widget.MediaNowPlayingView");
		map.put("android.support.v17.leanback.widget.MediaRowFocusView", "androidx.leanback.widget.MediaRowFocusView");
		map.put("android.support.v17.leanback.widget.MultiActionsProvider",
				"androidx.leanback.widget.MultiActionsProvider");
		map.put("android.support.v17.leanback.widget.NonOverlappingFrameLayout",
				"androidx.leanback.widget.NonOverlappingFrameLayout");
		map.put("android.support.v17.leanback.widget.NonOverlappingLinearLayout",
				"androidx.leanback.widget.NonOverlappingLinearLayout");
		map.put("android.support.v17.leanback.widget.NonOverlappingLinearLayoutWithForeground",
				"androidx.leanback.widget.NonOverlappingLinearLayoutWithForeground");
		map.put("android.support.v17.leanback.widget.NonOverlappingRelativeLayout",
				"androidx.leanback.widget.NonOverlappingRelativeLayout");
		map.put("android.support.v17.leanback.widget.NonOverlappingView",
				"androidx.leanback.widget.NonOverlappingView");
		map.put("android.support.v17.leanback.widget.ObjectAdapter", "androidx.leanback.widget.ObjectAdapter");
		map.put("android.support.v17.leanback.widget.OnActionClickedListener",
				"androidx.leanback.widget.OnActionClickedListener");
		map.put("android.support.v17.leanback.widget.OnChildLaidOutListener",
				"androidx.leanback.widget.OnChildLaidOutListener");
		map.put("android.support.v17.leanback.widget.OnChildSelectedListener",
				"androidx.leanback.widget.OnChildSelectedListener");
		map.put("android.support.v17.leanback.widget.OnChildViewHolderSelectedListener",
				"androidx.leanback.widget.OnChildViewHolderSelectedListener");
		map.put("android.support.v17.leanback.widget.OnItemViewClickedListener",
				"androidx.leanback.widget.OnItemViewClickedListener");
		map.put("android.support.v17.leanback.widget.OnItemViewSelectedListener",
				"androidx.leanback.widget.OnItemViewSelectedListener");
		map.put("android.support.v17.leanback.widget.PageRow", "androidx.leanback.widget.PageRow");
		map.put("android.support.v17.leanback.widget.PagingIndicator", "androidx.leanback.widget.PagingIndicator");
		map.put("android.support.v17.leanback.widget.Parallax", "androidx.leanback.widget.Parallax");
		map.put("android.support.v17.leanback.widget.ParallaxEffect", "androidx.leanback.widget.ParallaxEffect");
		map.put("android.support.v17.leanback.widget.ParallaxTarget", "androidx.leanback.widget.ParallaxTarget");
		map.put("android.support.v17.leanback.widget.PersistentFocusWrapper",
				"androidx.leanback.widget.PersistentFocusWrapper");
		map.put("android.support.v17.leanback.widget.picker.DatePicker", "androidx.leanback.widget.picker.DatePicker");
		map.put("android.support.v17.leanback.widget.picker.Picker", "androidx.leanback.widget.picker.Picker");
		map.put("android.support.v17.leanback.widget.picker.PickerColumn",
				"androidx.leanback.widget.picker.PickerColumn");
		map.put("android.support.v17.leanback.widget.picker.PickerUtility",
				"androidx.leanback.widget.picker.PickerUtility");
		map.put("android.support.v17.leanback.widget.picker.TimePicker", "androidx.leanback.widget.picker.TimePicker");
		map.put("android.support.v17.leanback.widget.PlaybackControlsPresenter",
				"androidx.leanback.widget.PlaybackControlsPresenter");
		map.put("android.support.v17.leanback.widget.PlaybackControlsRow",
				"androidx.leanback.widget.PlaybackControlsRow");
		map.put("android.support.v17.leanback.widget.PlaybackControlsRowPresenter",
				"androidx.leanback.widget.PlaybackControlsRowPresenter");
		map.put("android.support.v17.leanback.widget.PlaybackControlsRowView",
				"androidx.leanback.widget.PlaybackControlsRowView");
		map.put("android.support.v17.leanback.widget.PlaybackRowPresenter",
				"androidx.leanback.widget.PlaybackRowPresenter");
		map.put("android.support.v17.leanback.widget.PlaybackSeekDataProvider",
				"androidx.leanback.widget.PlaybackSeekDataProvider");
		map.put("android.support.v17.leanback.widget.PlaybackSeekUi", "androidx.leanback.widget.PlaybackSeekUi");
		map.put("android.support.v17.leanback.widget.PlaybackTransportRowPresenter",
				"androidx.leanback.widget.PlaybackTransportRowPresenter");
		map.put("android.support.v17.leanback.widget.PlaybackTransportRowView",
				"androidx.leanback.widget.PlaybackTransportRowView");
		map.put("android.support.v17.leanback.widget.Presenter", "androidx.leanback.widget.Presenter");
		map.put("android.support.v17.leanback.widget.PresenterSelector", "androidx.leanback.widget.PresenterSelector");
		map.put("android.support.v17.leanback.widget.PresenterSwitcher", "androidx.leanback.widget.PresenterSwitcher");
		map.put("android.support.v17.leanback.widget.RecyclerViewParallax",
				"androidx.leanback.widget.RecyclerViewParallax");
		map.put("android.support.v17.leanback.widget.ResizingTextView", "androidx.leanback.widget.ResizingTextView");
		map.put("android.support.v17.leanback.widget.RoundedRectHelper", "androidx.leanback.widget.RoundedRectHelper");
		map.put("android.support.v17.leanback.widget.RoundedRectHelperApi21",
				"androidx.leanback.widget.RoundedRectHelperApi21");
		map.put("android.support.v17.leanback.widget.Row", "androidx.leanback.widget.Row");
		map.put("android.support.v17.leanback.widget.RowContainerView", "androidx.leanback.widget.RowContainerView");
		map.put("android.support.v17.leanback.widget.RowHeaderPresenter",
				"androidx.leanback.widget.RowHeaderPresenter");
		map.put("android.support.v17.leanback.widget.RowHeaderView", "androidx.leanback.widget.RowHeaderView");
		map.put("android.support.v17.leanback.widget.RowPresenter", "androidx.leanback.widget.RowPresenter");
		map.put("android.support.v17.leanback.widget.ScaleFrameLayout", "androidx.leanback.widget.ScaleFrameLayout");
		map.put("android.support.v17.leanback.widget.SearchBar", "androidx.leanback.widget.SearchBar");
		map.put("android.support.v17.leanback.widget.SearchEditText", "androidx.leanback.widget.SearchEditText");
		map.put("android.support.v17.leanback.widget.SearchOrbView", "androidx.leanback.widget.SearchOrbView");
		map.put("android.support.v17.leanback.widget.SectionRow", "androidx.leanback.widget.SectionRow");
		map.put("android.support.v17.leanback.widget.SeekBar", "androidx.leanback.widget.SeekBar");
		map.put("android.support.v17.leanback.widget.ShadowHelper", "androidx.leanback.widget.ShadowHelper");
		map.put("android.support.v17.leanback.widget.ShadowHelperApi21", "androidx.leanback.widget.ShadowHelperApi21");
		map.put("android.support.v17.leanback.widget.ShadowOverlayContainer",
				"androidx.leanback.widget.ShadowOverlayContainer");
		map.put("android.support.v17.leanback.widget.ShadowOverlayHelper",
				"androidx.leanback.widget.ShadowOverlayHelper");
		map.put("android.support.v17.leanback.widget.SinglePresenterSelector",
				"androidx.leanback.widget.SinglePresenterSelector");
		map.put("android.support.v17.leanback.widget.SingleRow", "androidx.leanback.widget.SingleRow");
		map.put("android.support.v17.leanback.widget.SparseArrayObjectAdapter",
				"androidx.leanback.widget.SparseArrayObjectAdapter");
		map.put("android.support.v17.leanback.widget.SpeechOrbView", "androidx.leanback.widget.SpeechOrbView");
		map.put("android.support.v17.leanback.widget.SpeechRecognitionCallback",
				"androidx.leanback.widget.SpeechRecognitionCallback");
		map.put("android.support.v17.leanback.widget.StaggeredGrid", "androidx.leanback.widget.StaggeredGrid");
		map.put("android.support.v17.leanback.widget.StaggeredGridDefault",
				"androidx.leanback.widget.StaggeredGridDefault");
		map.put("android.support.v17.leanback.widget.StaticShadowHelper",
				"androidx.leanback.widget.StaticShadowHelper");
		map.put("android.support.v17.leanback.widget.StreamingTextView", "androidx.leanback.widget.StreamingTextView");
		map.put("android.support.v17.leanback.widget.ThumbsBar", "androidx.leanback.widget.ThumbsBar");
		map.put("android.support.v17.leanback.widget.TitleHelper", "androidx.leanback.widget.TitleHelper");
		map.put("android.support.v17.leanback.widget.TitleView", "androidx.leanback.widget.TitleView");
		map.put("android.support.v17.leanback.widget.TitleViewAdapter", "androidx.leanback.widget.TitleViewAdapter");
		map.put("android.support.v17.leanback.widget.Util", "androidx.leanback.widget.Util");
		map.put("android.support.v17.leanback.widget.VerticalGridPresenter",
				"androidx.leanback.widget.VerticalGridPresenter");
		map.put("android.support.v17.leanback.widget.VerticalGridView", "androidx.leanback.widget.VerticalGridView");
		map.put("android.support.v17.leanback.widget.VideoSurfaceView", "androidx.leanback.widget.VideoSurfaceView");
		map.put("android.support.v17.leanback.widget.ViewHolderTask", "androidx.leanback.widget.ViewHolderTask");
		map.put("android.support.v17.leanback.widget.ViewsStateBundle", "androidx.leanback.widget.ViewsStateBundle");
		map.put("android.support.v17.leanback.widget.Visibility", "androidx.leanback.widget.Visibility");
		map.put("android.support.v17.leanback.widget.WindowAlignment", "androidx.leanback.widget.WindowAlignment");
		map.put("android.support.v17.preference.BaseLeanbackPreferenceFragment",
				"androidx.leanback.preference.BaseLeanbackPreferenceFragment");
		map.put("android.support.v17.preference.LeanbackListPreferenceDialogFragment",
				"androidx.leanback.preference.LeanbackListPreferenceDialogFragment");
		map.put("android.support.v17.preference.LeanbackPreferenceDialogFragment",
				"androidx.leanback.preference.LeanbackPreferenceDialogFragment");
		map.put("android.support.v17.preference.LeanbackPreferenceFragment",
				"androidx.leanback.preference.LeanbackPreferenceFragment");
		map.put("android.support.v17.preference.LeanbackPreferenceFragmentTransitionHelperApi21",
				"androidx.leanback.preference.LeanbackPreferenceFragmentTransitionHelperApi21");
		map.put("android.support.v17.preference.LeanbackSettingsFragment",
				"androidx.leanback.preference.LeanbackSettingsFragment");
		map.put("android.support.v17.preference.LeanbackSettingsRootView",
				"androidx.leanback.preference.LeanbackSettingsRootView");
		map.put("android.support.v17.preference.R", "androidx.leanback.preference.R");
		map.put("android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat",
				"androidx.core.accessibilityservice.AccessibilityServiceInfoCompat");
		map.put("android.support.v4.app.ActionBarDrawerToggle", "androidx.legacy.app.ActionBarDrawerToggle");
		map.put("android.support.v4.app.ActivityCompat", "androidx.core.app.ActivityCompat");
		map.put("android.support.v4.app.ActivityManagerCompat", "androidx.core.app.ActivityManagerCompat");
		map.put("android.support.v4.app.ActivityOptionsCompat", "androidx.core.app.ActivityOptionsCompat");
		map.put("android.support.v4.app.AlarmManagerCompat", "androidx.core.app.AlarmManagerCompat");
		map.put("android.support.v4.app.AppComponentFactory", "androidx.core.app.AppComponentFactory");
		map.put("android.support.v4.app.AppLaunchChecker", "androidx.core.app.AppLaunchChecker");
		map.put("android.support.v4.app.AppOpsManagerCompat", "androidx.core.app.AppOpsManagerCompat");
		map.put("android.support.v4.app.BackStackRecord", "androidx.fragment.app.BackStackRecord");
		map.put("android.support.v4.app.BackStackState", "androidx.fragment.app.BackStackState");
		map.put("android.support.v4.app.BundleCompat", "androidx.core.app.BundleCompat");
		map.put("android.support.v4.app.CoreComponentFactory", "androidx.core.app.CoreComponentFactory");
		map.put("android.support.v4.app.DialogFragment", "androidx.fragment.app.DialogFragment");
		map.put("android.support.v4.app.Fragment", "androidx.fragment.app.Fragment");
		map.put("android.support.v4.app.FragmentActivity", "androidx.fragment.app.FragmentActivity");
		map.put("android.support.v4.app.FragmentContainer", "androidx.fragment.app.FragmentContainer");
		map.put("android.support.v4.app.FragmentController", "androidx.fragment.app.FragmentController");
		map.put("android.support.v4.app.FragmentHostCallback", "androidx.fragment.app.FragmentHostCallback");
		map.put("android.support.v4.app.FragmentManager", "androidx.fragment.app.FragmentManager");
		map.put("android.support.v4.app.FragmentManagerImpl", "androidx.fragment.app.FragmentManagerImpl");
		map.put("android.support.v4.app.FragmentManagerNonConfig", "androidx.fragment.app.FragmentManagerNonConfig");
		map.put("android.support.v4.app.FragmentManagerState", "androidx.fragment.app.FragmentManagerState");
		map.put("android.support.v4.app.FragmentPagerAdapter", "androidx.fragment.app.FragmentPagerAdapter");
		map.put("android.support.v4.app.FragmentState", "androidx.fragment.app.FragmentState");
		map.put("android.support.v4.app.FragmentStatePagerAdapter", "androidx.fragment.app.FragmentStatePagerAdapter");
		map.put("android.support.v4.app.FragmentTabHost", "androidx.fragment.app.FragmentTabHost");
		map.put("android.support.v4.app.FragmentTransaction", "androidx.fragment.app.FragmentTransaction");
		map.put("android.support.v4.app.FragmentTransition", "androidx.fragment.app.FragmentTransition");
		map.put("android.support.v4.app.FragmentTransitionCompat21",
				"androidx.fragment.app.FragmentTransitionCompat21");
		map.put("android.support.v4.app.FragmentTransitionImpl", "androidx.fragment.app.FragmentTransitionImpl");
		map.put("android.support.v4.app.FrameMetricsAggregator", "androidx.core.app.FrameMetricsAggregator");
		map.put("android.support.v4.app.INotificationSideChannel", "androidx.core.app.INotificationSideChannel");
		map.put("android.support.v4.app.JobIntentService", "androidx.core.app.JobIntentService");
		map.put("android.support.v4.app.ListFragment", "androidx.fragment.app.ListFragment");
		map.put("android.support.v4.app.LoaderManager", "androidx.loader.app.LoaderManager");
		map.put("android.support.v4.app.LoaderManagerImpl", "androidx.loader.app.LoaderManagerImpl");
		map.put("android.support.v4.app.NavUtils", "androidx.core.app.NavUtils");
		map.put("android.support.v4.app.NotificationBuilderWithBuilderAccessor",
				"androidx.core.app.NotificationBuilderWithBuilderAccessor");
		map.put("android.support.v4.app.NotificationCompat", "androidx.core.app.NotificationCompat");
		map.put("android.support.v4.app.NotificationCompatBuilder", "androidx.core.app.NotificationCompatBuilder");
		map.put("android.support.v4.app.NotificationCompatExtras", "androidx.core.app.NotificationCompatExtras");
		map.put("android.support.v4.app.NotificationCompatJellybean", "androidx.core.app.NotificationCompatJellybean");
		map.put("android.support.v4.app.NotificationCompatSideChannelService",
				"androidx.core.app.NotificationCompatSideChannelService");
		map.put("android.support.v4.app.NotificationManagerCompat", "androidx.core.app.NotificationManagerCompat");
		map.put("android.support.v4.app.OneShotPreDrawListener", "androidx.fragment.app.OneShotPreDrawListener");
		map.put("android.support.v4.app.Person", "androidx.core.app.Person");
		map.put("android.support.v4.app.RemoteInput", "androidx.core.app.RemoteInput");
		map.put("android.support.v4.app.ServiceCompat", "androidx.core.app.ServiceCompat");
		map.put("android.support.v4.app.ShareCompat", "androidx.core.app.ShareCompat");
		map.put("android.support.v4.app.SharedElementCallback", "androidx.core.app.SharedElementCallback");
		map.put("android.support.v4.app.SuperNotCalledException", "androidx.fragment.app.SuperNotCalledException");
		map.put("android.support.v4.app.SupportActivity", "androidx.core.app.ComponentActivity");
		map.put("android.support.v4.app.TaskStackBuilder", "androidx.core.app.TaskStackBuilder");
		map.put("android.support.v4.content.AsyncTaskLoader", "androidx.loader.content.AsyncTaskLoader");
		map.put("android.support.v4.content.ContentResolverCompat", "androidx.core.content.ContentResolverCompat");
		map.put("android.support.v4.content.ContextCompat", "androidx.core.content.ContextCompat");
		map.put("android.support.v4.content.CursorLoader", "androidx.loader.content.CursorLoader");
		map.put("android.support.v4.content.FileProvider", "androidx.core.content.FileProvider");
		map.put("android.support.v4.content.IntentCompat", "androidx.core.content.IntentCompat");
		map.put("android.support.v4.content.Loader", "androidx.loader.content.Loader");
		map.put("android.support.v4.content.LocalBroadcastManager",
				"androidx.localbroadcastmanager.content.LocalBroadcastManager");
		map.put("android.support.v4.content.MimeTypeFilter", "androidx.core.content.MimeTypeFilter");
		map.put("android.support.v4.content.ModernAsyncTask", "androidx.loader.content.ModernAsyncTask");
		map.put("android.support.v4.content.PermissionChecker", "androidx.core.content.PermissionChecker");
		map.put("android.support.v4.content.pm.ActivityInfoCompat", "androidx.core.content.pm.ActivityInfoCompat");
		map.put("android.support.v4.content.pm.PackageInfoCompat", "androidx.core.content.pm.PackageInfoCompat");
		map.put("android.support.v4.content.pm.PermissionInfoCompat", "androidx.core.content.pm.PermissionInfoCompat");
		map.put("android.support.v4.content.pm.ShortcutInfoCompat", "androidx.core.content.pm.ShortcutInfoCompat");
		map.put("android.support.v4.content.pm.ShortcutManagerCompat",
				"androidx.core.content.pm.ShortcutManagerCompat");
		map.put("android.support.v4.content.res.ColorStateListInflaterCompat",
				"androidx.core.content.res.ColorStateListInflaterCompat");
		map.put("android.support.v4.content.res.ComplexColorCompat", "androidx.core.content.res.ComplexColorCompat");
		map.put("android.support.v4.content.res.ConfigurationHelper", "androidx.core.content.res.ConfigurationHelper");
		map.put("android.support.v4.content.res.FontResourcesParserCompat",
				"androidx.core.content.res.FontResourcesParserCompat");
		map.put("android.support.v4.content.res.GradientColorInflaterCompat",
				"androidx.core.content.res.GradientColorInflaterCompat");
		map.put("android.support.v4.content.res.GrowingArrayUtils", "androidx.core.content.res.GrowingArrayUtils");
		map.put("android.support.v4.content.res.ResourcesCompat", "androidx.core.content.res.ResourcesCompat");
		map.put("android.support.v4.content.res.TypedArrayUtils", "androidx.core.content.res.TypedArrayUtils");
		map.put("android.support.v4.content.SharedPreferencesCompat", "androidx.core.content.SharedPreferencesCompat");
		map.put("android.support.v4.content.WakefulBroadcastReceiver",
				"androidx.legacy.content.WakefulBroadcastReceiver");
		map.put("android.support.v4.database.CursorWindowCompat", "androidx.core.database.CursorWindowCompat");
		map.put("android.support.v4.database.DatabaseUtilsCompat", "androidx.core.database.DatabaseUtilsCompat");
		map.put("android.support.v4.database.sqlite.SQLiteCursorCompat",
				"androidx.core.database.sqlite.SQLiteCursorCompat");
		map.put("android.support.v4.graphics.BitmapCompat", "androidx.core.graphics.BitmapCompat");
		map.put("android.support.v4.graphics.ColorUtils", "androidx.core.graphics.ColorUtils");
		map.put("android.support.v4.graphics.drawable.DrawableCompat",
				"androidx.core.graphics.drawable.DrawableCompat");
		map.put("android.support.v4.graphics.drawable.IconCompat", "androidx.core.graphics.drawable.IconCompat");
		map.put("android.support.v4.graphics.drawable.IconCompatParcelizer",
				"android.support.v4.graphics.drawable.IconCompatParcelizer");
		map.put("android.support.v4.graphics.drawable.RoundedBitmapDrawable",
				"androidx.core.graphics.drawable.RoundedBitmapDrawable");
		map.put("android.support.v4.graphics.drawable.RoundedBitmapDrawable21",
				"androidx.core.graphics.drawable.RoundedBitmapDrawable21");
		map.put("android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory",
				"androidx.core.graphics.drawable.RoundedBitmapDrawableFactory");
		map.put("android.support.v4.graphics.drawable.TintAwareDrawable",
				"androidx.core.graphics.drawable.TintAwareDrawable");
		map.put("android.support.v4.graphics.drawable.WrappedDrawable",
				"androidx.core.graphics.drawable.WrappedDrawable");
		map.put("android.support.v4.graphics.drawable.WrappedDrawableApi14",
				"androidx.core.graphics.drawable.WrappedDrawableApi14");
		map.put("android.support.v4.graphics.drawable.WrappedDrawableApi21",
				"androidx.core.graphics.drawable.WrappedDrawableApi21");
		map.put("android.support.v4.graphics.PaintCompat", "androidx.core.graphics.PaintCompat");
		map.put("android.support.v4.graphics.PathParser", "androidx.core.graphics.PathParser");
		map.put("android.support.v4.graphics.PathSegment", "androidx.core.graphics.PathSegment");
		map.put("android.support.v4.graphics.PathUtils", "androidx.core.graphics.PathUtils");
		map.put("android.support.v4.graphics.TypefaceCompat", "androidx.core.graphics.TypefaceCompat");
		map.put("android.support.v4.graphics.TypefaceCompatApi21Impl",
				"androidx.core.graphics.TypefaceCompatApi21Impl");
		map.put("android.support.v4.graphics.TypefaceCompatApi24Impl",
				"androidx.core.graphics.TypefaceCompatApi24Impl");
		map.put("android.support.v4.graphics.TypefaceCompatApi26Impl",
				"androidx.core.graphics.TypefaceCompatApi26Impl");
		map.put("android.support.v4.graphics.TypefaceCompatApi28Impl",
				"androidx.core.graphics.TypefaceCompatApi28Impl");
		map.put("android.support.v4.graphics.TypefaceCompatBaseImpl", "androidx.core.graphics.TypefaceCompatBaseImpl");
		map.put("android.support.v4.graphics.TypefaceCompatUtil", "androidx.core.graphics.TypefaceCompatUtil");
		map.put("android.support.v4.hardware.display.DisplayManagerCompat",
				"androidx.core.hardware.display.DisplayManagerCompat");
		map.put("android.support.v4.hardware.fingerprint.FingerprintManagerCompat",
				"androidx.core.hardware.fingerprint.FingerprintManagerCompat");
		map.put("android.support.v4.internal.view.SupportMenu", "androidx.core.internal.view.SupportMenu");
		map.put("android.support.v4.internal.view.SupportMenuItem", "androidx.core.internal.view.SupportMenuItem");
		map.put("android.support.v4.internal.view.SupportSubMenu", "androidx.core.internal.view.SupportSubMenu");
		map.put("android.support.v4.math.MathUtils", "androidx.core.math.MathUtils");
		map.put("android.support.v4.media.app.NotificationCompat", "androidx.media.app.NotificationCompat");
		map.put("android.support.v4.media.AudioAttributesCompat", "androidx.media.AudioAttributesCompat");
		map.put("android.support.v4.media.AudioAttributesImpl", "android.support.v4.media.AudioAttributesImpl");
		map.put("android.support.v4.media.AudioAttributesImplApi21",
				"android.support.v4.media.AudioAttributesImplApi21");
		map.put("android.support.v4.media.AudioAttributesImplBase", "android.support.v4.media.AudioAttributesImplBase");
		map.put("android.support.v4.media.MediaBrowserCompat", "android.support.v4.media.MediaBrowserCompat");
		map.put("android.support.v4.media.MediaBrowserCompatApi21", "android.support.v4.media.MediaBrowserCompatApi21");
		map.put("android.support.v4.media.MediaBrowserCompatApi23", "android.support.v4.media.MediaBrowserCompatApi23");
		map.put("android.support.v4.media.MediaBrowserCompatApi26", "android.support.v4.media.MediaBrowserCompatApi26");
		map.put("android.support.v4.media.MediaBrowserCompatUtils", "androidx.media.MediaBrowserCompatUtils");
		map.put("android.support.v4.media.MediaBrowserProtocol", "androidx.media.MediaBrowserProtocol");
		map.put("android.support.v4.media.MediaBrowserServiceCompat", "androidx.media.MediaBrowserServiceCompat");
		map.put("android.support.v4.media.MediaBrowserServiceCompatApi21",
				"androidx.media.MediaBrowserServiceCompatApi21");
		map.put("android.support.v4.media.MediaBrowserServiceCompatApi23",
				"androidx.media.MediaBrowserServiceCompatApi23");
		map.put("android.support.v4.media.MediaBrowserServiceCompatApi26",
				"androidx.media.MediaBrowserServiceCompatApi26");
		map.put("android.support.v4.media.MediaDescriptionCompat", "android.support.v4.media.MediaDescriptionCompat");
		map.put("android.support.v4.media.MediaDescriptionCompatApi21",
				"android.support.v4.media.MediaDescriptionCompatApi21");
		map.put("android.support.v4.media.MediaDescriptionCompatApi23",
				"android.support.v4.media.MediaDescriptionCompatApi23");
		map.put("android.support.v4.media.MediaMetadataCompat", "android.support.v4.media.MediaMetadataCompat");
		map.put("android.support.v4.media.MediaMetadataCompatApi21",
				"android.support.v4.media.MediaMetadataCompatApi21");
		map.put("android.support.v4.media.MediaSessionManager", "androidx.media.MediaSessionManager");
		map.put("android.support.v4.media.MediaSessionManagerImplApi21", "androidx.media.MediaSessionManagerImplApi21");
		map.put("android.support.v4.media.MediaSessionManagerImplApi28", "androidx.media.MediaSessionManagerImplApi28");
		map.put("android.support.v4.media.MediaSessionManagerImplBase", "androidx.media.MediaSessionManagerImplBase");
		map.put("android.support.v4.media.ParceledListSliceAdapterApi21",
				"android.support.v4.media.ParceledListSliceAdapterApi21");
		map.put("android.support.v4.media.RatingCompat", "android.support.v4.media.RatingCompat");
		map.put("android.support.v4.media.session.IMediaControllerCallback",
				"android.support.v4.media.session.IMediaControllerCallback");
		map.put("android.support.v4.media.session.IMediaSession", "android.support.v4.media.session.IMediaSession");
		map.put("android.support.v4.media.session.MediaButtonReceiver", "androidx.media.session.MediaButtonReceiver");
		map.put("android.support.v4.media.session.MediaControllerCompat",
				"android.support.v4.media.session.MediaControllerCompat");
		map.put("android.support.v4.media.session.MediaControllerCompatApi21",
				"android.support.v4.media.session.MediaControllerCompatApi21");
		map.put("android.support.v4.media.session.MediaControllerCompatApi23",
				"android.support.v4.media.session.MediaControllerCompatApi23");
		map.put("android.support.v4.media.session.MediaControllerCompatApi24",
				"android.support.v4.media.session.MediaControllerCompatApi24");
		map.put("android.support.v4.media.session.MediaSessionCompat",
				"android.support.v4.media.session.MediaSessionCompat");
		map.put("android.support.v4.media.session.MediaSessionCompatApi21",
				"android.support.v4.media.session.MediaSessionCompatApi21");
		map.put("android.support.v4.media.session.MediaSessionCompatApi22",
				"android.support.v4.media.session.MediaSessionCompatApi22");
		map.put("android.support.v4.media.session.MediaSessionCompatApi23",
				"android.support.v4.media.session.MediaSessionCompatApi23");
		map.put("android.support.v4.media.session.MediaSessionCompatApi24",
				"android.support.v4.media.session.MediaSessionCompatApi24");
		map.put("android.support.v4.media.session.ParcelableVolumeInfo",
				"android.support.v4.media.session.ParcelableVolumeInfo");
		map.put("android.support.v4.media.session.PlaybackStateCompat",
				"android.support.v4.media.session.PlaybackStateCompat");
		map.put("android.support.v4.media.session.PlaybackStateCompatApi21",
				"android.support.v4.media.session.PlaybackStateCompatApi21");
		map.put("android.support.v4.media.session.PlaybackStateCompatApi22",
				"android.support.v4.media.session.PlaybackStateCompatApi22");
		map.put("android.support.v4.media.VolumeProviderCompat", "androidx.media.VolumeProviderCompat");
		map.put("android.support.v4.media.VolumeProviderCompatApi21", "androidx.media.VolumeProviderCompatApi21");
		map.put("android.support.v4.net.ConnectivityManagerCompat", "androidx.core.net.ConnectivityManagerCompat");
		map.put("android.support.v4.net.DatagramSocketWrapper", "androidx.core.net.DatagramSocketWrapper");
		map.put("android.support.v4.net.TrafficStatsCompat", "androidx.core.net.TrafficStatsCompat");
		map.put("android.support.v4.os.BuildCompat", "androidx.core.os.BuildCompat");
		map.put("android.support.v4.os.CancellationSignal", "androidx.core.os.CancellationSignal");
		map.put("android.support.v4.os.ConfigurationCompat", "androidx.core.os.ConfigurationCompat");
		map.put("android.support.v4.os.EnvironmentCompat", "androidx.core.os.EnvironmentCompat");
		map.put("android.support.v4.os.HandlerCompat", "androidx.core.os.HandlerCompat");
		map.put("android.support.v4.os.IResultReceiver", "androidx.core.os.IResultReceiver");
		map.put("android.support.v4.os.LocaleHelper", "androidx.core.os.LocaleHelper");
		map.put("android.support.v4.os.LocaleListCompat", "androidx.core.os.LocaleListCompat");
		map.put("android.support.v4.os.LocaleListHelper", "androidx.core.os.LocaleListHelper");
		map.put("android.support.v4.os.LocaleListInterface", "androidx.core.os.LocaleListInterface");
		map.put("android.support.v4.os.OperationCanceledException", "androidx.core.os.OperationCanceledException");
		map.put("android.support.v4.os.ParcelableCompat", "androidx.core.os.ParcelableCompat");
		map.put("android.support.v4.os.ParcelableCompatCreatorCallbacks",
				"androidx.core.os.ParcelableCompatCreatorCallbacks");
		map.put("android.support.v4.os.ParcelCompat", "androidx.core.os.ParcelCompat");
		map.put("android.support.v4.os.ResultReceiver", "androidx.core.os.ResultReceiver");
		map.put("android.support.v4.os.TraceCompat", "androidx.core.os.TraceCompat");
		map.put("android.support.v4.os.UserManagerCompat", "androidx.core.os.UserManagerCompat");
		map.put("android.support.v4.print.PrintHelper", "androidx.print.PrintHelper");
		map.put("android.support.v4.provider.DocumentFile", "androidx.documentfile.provider.DocumentFile");
		map.put("android.support.v4.provider.DocumentsContractApi19",
				"androidx.documentfile.provider.DocumentsContractApi19");
		map.put("android.support.v4.provider.FontRequest", "androidx.core.provider.FontRequest");
		map.put("android.support.v4.provider.FontsContractCompat", "androidx.core.provider.FontsContractCompat");
		map.put("android.support.v4.provider.RawDocumentFile", "androidx.documentfile.provider.RawDocumentFile");
		map.put("android.support.v4.provider.SelfDestructiveThread", "androidx.core.provider.SelfDestructiveThread");
		map.put("android.support.v4.provider.SingleDocumentFile", "androidx.documentfile.provider.SingleDocumentFile");
		map.put("android.support.v4.provider.TreeDocumentFile", "androidx.documentfile.provider.TreeDocumentFile");
		map.put("android.support.v4.text.BidiFormatter", "androidx.core.text.BidiFormatter");
		map.put("android.support.v4.text.HtmlCompat", "androidx.core.text.HtmlCompat");
		map.put("android.support.v4.text.ICUCompat", "androidx.core.text.ICUCompat");
		map.put("android.support.v4.text.PrecomputedTextCompat", "androidx.core.text.PrecomputedTextCompat");
		map.put("android.support.v4.text.TextDirectionHeuristicCompat",
				"androidx.core.text.TextDirectionHeuristicCompat");
		map.put("android.support.v4.text.TextDirectionHeuristicsCompat",
				"androidx.core.text.TextDirectionHeuristicsCompat");
		map.put("android.support.v4.text.TextUtilsCompat", "androidx.core.text.TextUtilsCompat");
		map.put("android.support.v4.text.util.FindAddress", "androidx.core.text.util.FindAddress");
		map.put("android.support.v4.text.util.LinkifyCompat", "androidx.core.text.util.LinkifyCompat");
		map.put("android.support.v4.util.ArrayMap", "androidx.collection.ArrayMap");
		map.put("android.support.v4.util.ArraySet", "androidx.collection.ArraySet");
		map.put("android.support.v4.util.AtomicFile", "androidx.core.util.AtomicFile");
		map.put("android.support.v4.util.CircularArray", "androidx.collection.CircularArray");
		map.put("android.support.v4.util.CircularIntArray", "androidx.collection.CircularIntArray");
		map.put("android.support.v4.util.Consumer", "androidx.core.util.Consumer");
		map.put("android.support.v4.util.ContainerHelpers", "androidx.collection.ContainerHelpers");
		map.put("android.support.v4.util.DebugUtils", "androidx.core.util.DebugUtils");
		map.put("android.support.v4.util.LogWriter", "androidx.core.util.LogWriter");
		map.put("android.support.v4.util.LongSparseArray", "androidx.collection.LongSparseArray");
		map.put("android.support.v4.util.LruCache", "androidx.collection.LruCache");
		map.put("android.support.v4.util.MapCollections", "androidx.collection.MapCollections");
		map.put("android.support.v4.util.ObjectsCompat", "androidx.core.util.ObjectsCompat");
		map.put("android.support.v4.util.Pair", "androidx.core.util.Pair");
		map.put("android.support.v4.util.PatternsCompat", "androidx.core.util.PatternsCompat");
		map.put("android.support.v4.util.Pools", "androidx.core.util.Pools");
		map.put("android.support.v4.util.Preconditions", "androidx.core.util.Preconditions");
		map.put("android.support.v4.util.SimpleArrayMap", "androidx.collection.SimpleArrayMap");
		map.put("android.support.v4.util.SparseArrayCompat", "androidx.collection.SparseArrayCompat");
		map.put("android.support.v4.util.TimeUtils", "androidx.core.util.TimeUtils");
		map.put("android.support.v4.view.AbsSavedState", "androidx.customview.view.AbsSavedState");
		map.put("android.support.v4.view.accessibility.AccessibilityEventCompat",
				"androidx.core.view.accessibility.AccessibilityEventCompat");
		map.put("android.support.v4.view.accessibility.AccessibilityManagerCompat",
				"androidx.core.view.accessibility.AccessibilityManagerCompat");
		map.put("android.support.v4.view.accessibility.AccessibilityNodeInfoCompat",
				"androidx.core.view.accessibility.AccessibilityNodeInfoCompat");
		map.put("android.support.v4.view.accessibility.AccessibilityNodeProviderCompat",
				"androidx.core.view.accessibility.AccessibilityNodeProviderCompat");
		map.put("android.support.v4.view.accessibility.AccessibilityRecordCompat",
				"androidx.core.view.accessibility.AccessibilityRecordCompat");
		map.put("android.support.v4.view.accessibility.AccessibilityWindowInfoCompat",
				"androidx.core.view.accessibility.AccessibilityWindowInfoCompat");
		map.put("android.support.v4.view.AccessibilityDelegateCompat",
				"androidx.core.view.AccessibilityDelegateCompat");
		map.put("android.support.v4.view.ActionProvider", "androidx.core.view.ActionProvider");
		map.put("android.support.v4.view.animation.FastOutLinearInInterpolator",
				"androidx.interpolator.view.animation.FastOutLinearInInterpolator");
		map.put("android.support.v4.view.animation.FastOutSlowInInterpolator",
				"androidx.interpolator.view.animation.FastOutSlowInInterpolator");
		map.put("android.support.v4.view.animation.LinearOutSlowInInterpolator",
				"androidx.interpolator.view.animation.LinearOutSlowInInterpolator");
		map.put("android.support.v4.view.animation.LookupTableInterpolator",
				"androidx.interpolator.view.animation.LookupTableInterpolator");
		map.put("android.support.v4.view.animation.PathInterpolatorApi14",
				"androidx.core.view.animation.PathInterpolatorApi14");
		map.put("android.support.v4.view.animation.PathInterpolatorCompat",
				"androidx.core.view.animation.PathInterpolatorCompat");
		map.put("android.support.v4.view.AsyncLayoutInflater", "androidx.asynclayoutinflater.view.AsyncLayoutInflater");
		map.put("android.support.v4.view.DisplayCutoutCompat", "androidx.core.view.DisplayCutoutCompat");
		map.put("android.support.v4.view.GestureDetectorCompat", "androidx.core.view.GestureDetectorCompat");
		map.put("android.support.v4.view.GravityCompat", "androidx.core.view.GravityCompat");
		map.put("android.support.v4.view.InputDeviceCompat", "androidx.core.view.InputDeviceCompat");
		map.put("android.support.v4.view.KeyEventDispatcher", "androidx.core.view.KeyEventDispatcher");
		map.put("android.support.v4.view.LayoutInflaterCompat", "androidx.core.view.LayoutInflaterCompat");
		map.put("android.support.v4.view.LayoutInflaterFactory", "androidx.core.view.LayoutInflaterFactory");
		map.put("android.support.v4.view.MarginLayoutParamsCompat", "androidx.core.view.MarginLayoutParamsCompat");
		map.put("android.support.v4.view.MenuCompat", "androidx.core.view.MenuCompat");
		map.put("android.support.v4.view.MenuItemCompat", "androidx.core.view.MenuItemCompat");
		map.put("android.support.v4.view.MotionEventCompat", "androidx.core.view.MotionEventCompat");
		map.put("android.support.v4.view.NestedScrollingChild", "androidx.core.view.NestedScrollingChild");
		map.put("android.support.v4.view.NestedScrollingChild2", "androidx.core.view.NestedScrollingChild2");
		map.put("android.support.v4.view.NestedScrollingChildHelper", "androidx.core.view.NestedScrollingChildHelper");
		map.put("android.support.v4.view.NestedScrollingParent", "androidx.core.view.NestedScrollingParent");
		map.put("android.support.v4.view.NestedScrollingParent2", "androidx.core.view.NestedScrollingParent2");
		map.put("android.support.v4.view.NestedScrollingParentHelper",
				"androidx.core.view.NestedScrollingParentHelper");
		map.put("android.support.v4.view.OnApplyWindowInsetsListener",
				"androidx.core.view.OnApplyWindowInsetsListener");
		map.put("android.support.v4.view.PagerAdapter", "androidx.viewpager.widget.PagerAdapter");
		map.put("android.support.v4.view.PagerTabStrip", "androidx.viewpager.widget.PagerTabStrip");
		map.put("android.support.v4.view.PagerTitleStrip", "androidx.viewpager.widget.PagerTitleStrip");
		map.put("android.support.v4.view.PointerIconCompat", "androidx.core.view.PointerIconCompat");
		map.put("android.support.v4.view.ScaleGestureDetectorCompat", "androidx.core.view.ScaleGestureDetectorCompat");
		map.put("android.support.v4.view.ScrollingView", "androidx.core.view.ScrollingView");
		map.put("android.support.v4.view.TintableBackgroundView", "androidx.core.view.TintableBackgroundView");
		map.put("android.support.v4.view.VelocityTrackerCompat", "androidx.core.view.VelocityTrackerCompat");
		map.put("android.support.v4.view.ViewCompat", "androidx.core.view.ViewCompat");
		map.put("android.support.v4.view.ViewConfigurationCompat", "androidx.core.view.ViewConfigurationCompat");
		map.put("android.support.v4.view.ViewGroupCompat", "androidx.core.view.ViewGroupCompat");
		map.put("android.support.v4.view.ViewPager", "androidx.viewpager.widget.ViewPager");
		map.put("android.support.v4.view.ViewParentCompat", "androidx.core.view.ViewParentCompat");
		map.put("android.support.v4.view.ViewPropertyAnimatorCompat", "androidx.core.view.ViewPropertyAnimatorCompat");
		map.put("android.support.v4.view.ViewPropertyAnimatorListener",
				"androidx.core.view.ViewPropertyAnimatorListener");
		map.put("android.support.v4.view.ViewPropertyAnimatorListenerAdapter",
				"androidx.core.view.ViewPropertyAnimatorListenerAdapter");
		map.put("android.support.v4.view.ViewPropertyAnimatorUpdateListener",
				"androidx.core.view.ViewPropertyAnimatorUpdateListener");
		map.put("android.support.v4.view.WindowCompat", "androidx.core.view.WindowCompat");
		map.put("android.support.v4.view.WindowInsetsCompat", "androidx.core.view.WindowInsetsCompat");
		map.put("android.support.v4.widget.AutoScrollHelper", "androidx.core.widget.AutoScrollHelper");
		map.put("android.support.v4.widget.AutoSizeableTextView", "androidx.core.widget.AutoSizeableTextView");
		map.put("android.support.v4.widget.CircleImageView", "androidx.swiperefreshlayout.widget.CircleImageView");
		map.put("android.support.v4.widget.CircularProgressDrawable",
				"androidx.swiperefreshlayout.widget.CircularProgressDrawable");
		map.put("android.support.v4.widget.CompoundButtonCompat", "androidx.core.widget.CompoundButtonCompat");
		map.put("android.support.v4.widget.ContentLoadingProgressBar",
				"androidx.core.widget.ContentLoadingProgressBar");
		map.put("android.support.v4.widget.CursorAdapter", "androidx.cursoradapter.widget.CursorAdapter");
		map.put("android.support.v4.widget.CursorFilter", "androidx.cursoradapter.widget.CursorFilter");
		map.put("android.support.v4.widget.DirectedAcyclicGraph",
				"androidx.coordinatorlayout.widget.DirectedAcyclicGraph");
		map.put("android.support.v4.widget.DrawerLayout", "androidx.drawerlayout.widget.DrawerLayout");
		map.put("android.support.v4.widget.EdgeEffectCompat", "androidx.core.widget.EdgeEffectCompat");
		map.put("android.support.v4.widget.ExploreByTouchHelper", "androidx.customview.widget.ExploreByTouchHelper");
		map.put("android.support.v4.widget.FocusStrategy", "androidx.customview.widget.FocusStrategy");
		map.put("android.support.v4.widget.ImageViewCompat", "androidx.core.widget.ImageViewCompat");
		map.put("android.support.v4.widget.ListPopupWindowCompat", "androidx.core.widget.ListPopupWindowCompat");
		map.put("android.support.v4.widget.ListViewAutoScrollHelper", "androidx.core.widget.ListViewAutoScrollHelper");
		map.put("android.support.v4.widget.ListViewCompat", "androidx.core.widget.ListViewCompat");
		map.put("android.support.v4.widget.NestedScrollView", "androidx.core.widget.NestedScrollView");
		map.put("android.support.v4.widget.PopupMenuCompat", "androidx.core.widget.PopupMenuCompat");
		map.put("android.support.v4.widget.PopupWindowCompat", "androidx.core.widget.PopupWindowCompat");
		map.put("android.support.v4.widget.ResourceCursorAdapter",
				"androidx.cursoradapter.widget.ResourceCursorAdapter");
		map.put("android.support.v4.widget.ScrollerCompat", "androidx.core.widget.ScrollerCompat");
		map.put("android.support.v4.widget.SimpleCursorAdapter", "androidx.cursoradapter.widget.SimpleCursorAdapter");
		map.put("android.support.v4.widget.SlidingPaneLayout", "androidx.slidingpanelayout.widget.SlidingPaneLayout");
		map.put("android.support.v4.widget.Space", "androidx.legacy.widget.Space");
		map.put("android.support.v4.widget.SwipeRefreshLayout",
				"androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
		map.put("android.support.v4.widget.TextViewCompat", "androidx.core.widget.TextViewCompat");
		map.put("android.support.v4.widget.TintableCompoundButton", "androidx.core.widget.TintableCompoundButton");
		map.put("android.support.v4.widget.TintableImageSourceView", "androidx.core.widget.TintableImageSourceView");
		map.put("android.support.v4.widget.ViewDragHelper", "androidx.customview.widget.ViewDragHelper");
		map.put("android.support.v4.widget.ViewGroupUtils", "androidx.coordinatorlayout.widget.ViewGroupUtils");
		map.put("android.support.v7.app.ActionBar", "androidx.appcompat.app.ActionBar");
		map.put("android.support.v7.app.ActionBarDrawerToggle", "androidx.appcompat.app.ActionBarDrawerToggle");
		map.put("android.support.v7.app.ActionBarDrawerToggleHoneycomb",
				"androidx.appcompat.app.ActionBarDrawerToggleHoneycomb");
		map.put("android.support.v7.app.AlertController", "androidx.appcompat.app.AlertController");
		map.put("android.support.v7.app.AlertDialog", "androidx.appcompat.app.AlertDialog");
		map.put("android.support.v7.app.AppCompatActivity", "androidx.appcompat.app.AppCompatActivity");
		map.put("android.support.v7.app.AppCompatCallback", "androidx.appcompat.app.AppCompatCallback");
		map.put("android.support.v7.app.AppCompatDelegate", "androidx.appcompat.app.AppCompatDelegate");
		map.put("android.support.v7.app.AppCompatDelegateImpl", "androidx.appcompat.app.AppCompatDelegateImpl");
		map.put("android.support.v7.app.AppCompatDialog", "androidx.appcompat.app.AppCompatDialog");
		map.put("android.support.v7.app.AppCompatDialogFragment", "androidx.appcompat.app.AppCompatDialogFragment");
		map.put("android.support.v7.app.AppCompatViewInflater", "androidx.appcompat.app.AppCompatViewInflater");
		map.put("android.support.v7.app.MediaRouteActionProvider", "androidx.mediarouter.app.MediaRouteActionProvider");
		map.put("android.support.v7.app.MediaRouteButton", "androidx.mediarouter.app.MediaRouteButton");
		map.put("android.support.v7.app.MediaRouteCastDialog", "androidx.mediarouter.app.MediaRouteCastDialog");
		map.put("android.support.v7.app.MediaRouteChooserDialog", "androidx.mediarouter.app.MediaRouteChooserDialog");
		map.put("android.support.v7.app.MediaRouteChooserDialogFragment",
				"androidx.mediarouter.app.MediaRouteChooserDialogFragment");
		map.put("android.support.v7.app.MediaRouteControllerDialog",
				"androidx.mediarouter.app.MediaRouteControllerDialog");
		map.put("android.support.v7.app.MediaRouteControllerDialogFragment",
				"androidx.mediarouter.app.MediaRouteControllerDialogFragment");
		map.put("android.support.v7.app.MediaRouteDevicePickerDialog",
				"androidx.mediarouter.app.MediaRouteDevicePickerDialog");
		map.put("android.support.v7.app.MediaRouteDialogFactory", "androidx.mediarouter.app.MediaRouteDialogFactory");
		map.put("android.support.v7.app.MediaRouteDialogHelper", "androidx.mediarouter.app.MediaRouteDialogHelper");
		map.put("android.support.v7.app.MediaRouteDiscoveryFragment",
				"androidx.mediarouter.app.MediaRouteDiscoveryFragment");
		map.put("android.support.v7.app.MediaRouteExpandCollapseButton",
				"androidx.mediarouter.app.MediaRouteExpandCollapseButton");
		map.put("android.support.v7.app.MediaRouterThemeHelper", "androidx.mediarouter.app.MediaRouterThemeHelper");
		map.put("android.support.v7.app.MediaRouteVolumeSlider", "androidx.mediarouter.app.MediaRouteVolumeSlider");
		map.put("android.support.v7.app.NavItemSelectedListener", "androidx.appcompat.app.NavItemSelectedListener");
		map.put("android.support.v7.app.OverlayListView", "androidx.mediarouter.app.OverlayListView");
		map.put("android.support.v7.app.ResourcesFlusher", "androidx.appcompat.app.ResourcesFlusher");
		map.put("android.support.v7.app.ToolbarActionBar", "androidx.appcompat.app.ToolbarActionBar");
		map.put("android.support.v7.app.TwilightCalculator", "androidx.appcompat.app.TwilightCalculator");
		map.put("android.support.v7.app.TwilightManager", "androidx.appcompat.app.TwilightManager");
		map.put("android.support.v7.app.WindowDecorActionBar", "androidx.appcompat.app.WindowDecorActionBar");
		map.put("android.support.v7.appcompat.R", "androidx.appcompat.R");
		map.put("android.support.v7.cardview.R", "androidx.cardview.R");
		map.put("android.support.v7.content.res.AppCompatResources",
				"androidx.appcompat.content.res.AppCompatResources");
		map.put("android.support.v7.graphics.ColorCutQuantizer", "androidx.palette.graphics.ColorCutQuantizer");
		map.put("android.support.v7.graphics.drawable.AnimatedStateListDrawableCompat",
				"androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat");
		map.put("android.support.v7.graphics.drawable.DrawableContainer",
				"androidx.appcompat.graphics.drawable.DrawableContainer");
		map.put("android.support.v7.graphics.drawable.DrawableWrapper",
				"androidx.appcompat.graphics.drawable.DrawableWrapper");
		map.put("android.support.v7.graphics.drawable.DrawerArrowDrawable",
				"androidx.appcompat.graphics.drawable.DrawerArrowDrawable");
		map.put("android.support.v7.graphics.drawable.StateListDrawable",
				"androidx.appcompat.graphics.drawable.StateListDrawable");
		map.put("android.support.v7.graphics.Palette", "androidx.palette.graphics.Palette");
		map.put("android.support.v7.graphics.Target", "androidx.palette.graphics.Target");
		map.put("android.support.v7.gridlayout.R", "androidx.gridlayout.R");
		map.put("android.support.v7.internal.widget.PreferenceImageView",
				"androidx.preference.internal.PreferenceImageView");
		map.put("android.support.v7.media.MediaControlIntent", "androidx.mediarouter.media.MediaControlIntent");
		map.put("android.support.v7.media.MediaItemMetadata", "androidx.mediarouter.media.MediaItemMetadata");
		map.put("android.support.v7.media.MediaItemStatus", "androidx.mediarouter.media.MediaItemStatus");
		map.put("android.support.v7.media.MediaRouteDescriptor", "androidx.mediarouter.media.MediaRouteDescriptor");
		map.put("android.support.v7.media.MediaRouteDiscoveryRequest",
				"androidx.mediarouter.media.MediaRouteDiscoveryRequest");
		map.put("android.support.v7.media.MediaRouteProvider", "androidx.mediarouter.media.MediaRouteProvider");
		map.put("android.support.v7.media.MediaRouteProviderDescriptor",
				"androidx.mediarouter.media.MediaRouteProviderDescriptor");
		map.put("android.support.v7.media.MediaRouteProviderProtocol",
				"androidx.mediarouter.media.MediaRouteProviderProtocol");
		map.put("android.support.v7.media.MediaRouteProviderService",
				"androidx.mediarouter.media.MediaRouteProviderService");
		map.put("android.support.v7.media.MediaRouter", "androidx.mediarouter.media.MediaRouter");
		map.put("android.support.v7.media.MediaRouterApi24", "androidx.mediarouter.media.MediaRouterApi24");
		map.put("android.support.v7.media.MediaRouterJellybean", "androidx.mediarouter.media.MediaRouterJellybean");
		map.put("android.support.v7.media.MediaRouterJellybeanMr1",
				"androidx.mediarouter.media.MediaRouterJellybeanMr1");
		map.put("android.support.v7.media.MediaRouterJellybeanMr2",
				"androidx.mediarouter.media.MediaRouterJellybeanMr2");
		map.put("android.support.v7.media.MediaRouteSelector", "androidx.mediarouter.media.MediaRouteSelector");
		map.put("android.support.v7.media.MediaSessionStatus", "androidx.mediarouter.media.MediaSessionStatus");
		map.put("android.support.v7.media.RegisteredMediaRouteProvider",
				"androidx.mediarouter.media.RegisteredMediaRouteProvider");
		map.put("android.support.v7.media.RegisteredMediaRouteProviderWatcher",
				"androidx.mediarouter.media.RegisteredMediaRouteProviderWatcher");
		map.put("android.support.v7.media.RemoteControlClientCompat",
				"androidx.mediarouter.media.RemoteControlClientCompat");
		map.put("android.support.v7.media.RemotePlaybackClient", "androidx.mediarouter.media.RemotePlaybackClient");
		map.put("android.support.v7.media.RouteMediaPlayerConnector",
				"androidx.mediarouter.media.RouteMediaPlayerConnector");
		map.put("android.support.v7.media.SystemMediaRouteProvider",
				"androidx.mediarouter.media.SystemMediaRouteProvider");
		map.put("android.support.v7.mediarouter.R", "androidx.mediarouter.R");
		map.put("android.support.v7.preference.AndroidResources", "androidx.preference.AndroidResources");
		map.put("android.support.v7.preference.CheckBoxPreference", "androidx.preference.CheckBoxPreference");
		map.put("android.support.v7.preference.CollapsiblePreferenceGroupController",
				"androidx.preference.CollapsiblePreferenceGroupController");
		map.put("android.support.v7.preference.DialogPreference", "androidx.preference.DialogPreference");
		map.put("android.support.v7.preference.DropDownPreference", "androidx.preference.DropDownPreference");
		map.put("android.support.v7.preference.EditTextPreference", "androidx.preference.EditTextPreference");
		map.put("android.support.v7.preference.EditTextPreferenceDialogFragmentCompat",
				"androidx.preference.EditTextPreferenceDialogFragmentCompat");
		map.put("android.support.v7.preference.internal.AbstractMultiSelectListPreference",
				"androidx.preference.internal.AbstractMultiSelectListPreference");
		map.put("android.support.v7.preference.ListPreference", "androidx.preference.ListPreference");
		map.put("android.support.v7.preference.ListPreferenceDialogFragmentCompat",
				"androidx.preference.ListPreferenceDialogFragmentCompat");
		map.put("android.support.v7.preference.MultiSelectListPreferenceDialogFragmentCompat",
				"androidx.preference.MultiSelectListPreferenceDialogFragmentCompat");
		map.put("android.support.v7.preference.Preference", "androidx.preference.Preference");
		map.put("android.support.v7.preference.PreferenceCategory", "androidx.preference.PreferenceCategory");
		map.put("android.support.v7.preference.PreferenceDataStore", "androidx.preference.PreferenceDataStore");
		map.put("android.support.v7.preference.PreferenceDialogFragmentCompat",
				"androidx.preference.PreferenceDialogFragmentCompat");
		map.put("android.support.v7.preference.PreferenceFragmentCompat",
				"androidx.preference.PreferenceFragmentCompat");
		map.put("android.support.v7.preference.PreferenceGroup", "androidx.preference.PreferenceGroup");
		map.put("android.support.v7.preference.PreferenceGroupAdapter", "androidx.preference.PreferenceGroupAdapter");
		map.put("android.support.v7.preference.PreferenceInflater", "androidx.preference.PreferenceInflater");
		map.put("android.support.v7.preference.PreferenceManager", "androidx.preference.PreferenceManager");
		map.put("android.support.v7.preference.PreferenceRecyclerViewAccessibilityDelegate",
				"androidx.preference.PreferenceRecyclerViewAccessibilityDelegate");
		map.put("android.support.v7.preference.PreferenceScreen", "androidx.preference.PreferenceScreen");
		map.put("android.support.v7.preference.PreferenceViewHolder", "androidx.preference.PreferenceViewHolder");
		map.put("android.support.v7.preference.R", "androidx.preference.R");
		map.put("android.support.v7.preference.SeekBarPreference", "androidx.preference.SeekBarPreference");
		map.put("android.support.v7.preference.SwitchPreferenceCompat", "androidx.preference.SwitchPreferenceCompat");
		map.put("android.support.v7.preference.TwoStatePreference", "androidx.preference.TwoStatePreference");
		map.put("android.support.v7.preference.UnPressableLinearLayout", "androidx.preference.UnPressableLinearLayout");
		map.put("android.support.v7.recyclerview.extensions.AsyncDifferConfig",
				"androidx.recyclerview.widget.AsyncDifferConfig");
		map.put("android.support.v7.recyclerview.extensions.AsyncListDiffer",
				"androidx.recyclerview.widget.AsyncListDiffer");
		map.put("android.support.v7.recyclerview.extensions.ListAdapter", "androidx.recyclerview.widget.ListAdapter");
		map.put("android.support.v7.recyclerview.R", "androidx.recyclerview.R");
		map.put("android.support.v7.text.AllCapsTransformationMethod",
				"androidx.appcompat.text.AllCapsTransformationMethod");
		map.put("android.support.v7.util.AdapterListUpdateCallback",
				"androidx.recyclerview.widget.AdapterListUpdateCallback");
		map.put("android.support.v7.util.AsyncListUtil", "androidx.recyclerview.widget.AsyncListUtil");
		map.put("android.support.v7.util.BatchingListUpdateCallback",
				"androidx.recyclerview.widget.BatchingListUpdateCallback");
		map.put("android.support.v7.util.DiffUtil", "androidx.recyclerview.widget.DiffUtil");
		map.put("android.support.v7.util.ListUpdateCallback", "androidx.recyclerview.widget.ListUpdateCallback");
		map.put("android.support.v7.util.MessageThreadUtil", "androidx.recyclerview.widget.MessageThreadUtil");
		map.put("android.support.v7.util.SortedList", "androidx.recyclerview.widget.SortedList");
		map.put("android.support.v7.util.ThreadUtil", "androidx.recyclerview.widget.ThreadUtil");
		map.put("android.support.v7.util.TileList", "androidx.recyclerview.widget.TileList");
		map.put("android.support.v7.view.ActionBarPolicy", "androidx.appcompat.view.ActionBarPolicy");
		map.put("android.support.v7.view.ActionMode", "androidx.appcompat.view.ActionMode");
		map.put("android.support.v7.view.CollapsibleActionView", "androidx.appcompat.view.CollapsibleActionView");
		map.put("android.support.v7.view.ContextThemeWrapper", "androidx.appcompat.view.ContextThemeWrapper");
		map.put("android.support.v7.view.menu.ActionMenuItem", "androidx.appcompat.view.menu.ActionMenuItem");
		map.put("android.support.v7.view.menu.ActionMenuItemView", "androidx.appcompat.view.menu.ActionMenuItemView");
		map.put("android.support.v7.view.menu.BaseMenuPresenter", "androidx.appcompat.view.menu.BaseMenuPresenter");
		map.put("android.support.v7.view.menu.BaseMenuWrapper", "androidx.appcompat.view.menu.BaseMenuWrapper");
		map.put("android.support.v7.view.menu.BaseWrapper", "androidx.appcompat.view.menu.BaseWrapper");
		map.put("android.support.v7.view.menu.CascadingMenuPopup", "androidx.appcompat.view.menu.CascadingMenuPopup");
		map.put("android.support.v7.view.menu.ExpandedMenuView", "androidx.appcompat.view.menu.ExpandedMenuView");
		map.put("android.support.v7.view.menu.ListMenuItemView", "androidx.appcompat.view.menu.ListMenuItemView");
		map.put("android.support.v7.view.menu.ListMenuPresenter", "androidx.appcompat.view.menu.ListMenuPresenter");
		map.put("android.support.v7.view.menu.MenuAdapter", "androidx.appcompat.view.menu.MenuAdapter");
		map.put("android.support.v7.view.menu.MenuBuilder", "androidx.appcompat.view.menu.MenuBuilder");
		map.put("android.support.v7.view.menu.MenuDialogHelper", "androidx.appcompat.view.menu.MenuDialogHelper");
		map.put("android.support.v7.view.menu.MenuHelper", "androidx.appcompat.view.menu.MenuHelper");
		map.put("android.support.v7.view.menu.MenuItemImpl", "androidx.appcompat.view.menu.MenuItemImpl");
		map.put("android.support.v7.view.menu.MenuItemWrapperICS", "androidx.appcompat.view.menu.MenuItemWrapperICS");
		map.put("android.support.v7.view.menu.MenuItemWrapperJB", "androidx.appcompat.view.menu.MenuItemWrapperJB");
		map.put("android.support.v7.view.menu.MenuPopup", "androidx.appcompat.view.menu.MenuPopup");
		map.put("android.support.v7.view.menu.MenuPopupHelper", "androidx.appcompat.view.menu.MenuPopupHelper");
		map.put("android.support.v7.view.menu.MenuPresenter", "androidx.appcompat.view.menu.MenuPresenter");
		map.put("android.support.v7.view.menu.MenuView", "androidx.appcompat.view.menu.MenuView");
		map.put("android.support.v7.view.menu.MenuWrapperFactory", "androidx.appcompat.view.menu.MenuWrapperFactory");
		map.put("android.support.v7.view.menu.MenuWrapperICS", "androidx.appcompat.view.menu.MenuWrapperICS");
		map.put("android.support.v7.view.menu.ShowableListMenu", "androidx.appcompat.view.menu.ShowableListMenu");
		map.put("android.support.v7.view.menu.StandardMenuPopup", "androidx.appcompat.view.menu.StandardMenuPopup");
		map.put("android.support.v7.view.menu.SubMenuBuilder", "androidx.appcompat.view.menu.SubMenuBuilder");
		map.put("android.support.v7.view.menu.SubMenuWrapperICS", "androidx.appcompat.view.menu.SubMenuWrapperICS");
		map.put("android.support.v7.view.StandaloneActionMode", "androidx.appcompat.view.StandaloneActionMode");
		map.put("android.support.v7.view.SupportActionModeWrapper", "androidx.appcompat.view.SupportActionModeWrapper");
		map.put("android.support.v7.view.SupportMenuInflater", "androidx.appcompat.view.SupportMenuInflater");
		map.put("android.support.v7.view.ViewPropertyAnimatorCompatSet",
				"androidx.appcompat.view.ViewPropertyAnimatorCompatSet");
		map.put("android.support.v7.view.WindowCallbackWrapper", "androidx.appcompat.view.WindowCallbackWrapper");
		map.put("android.support.v7.widget.AbsActionBarView", "androidx.appcompat.widget.AbsActionBarView");
		map.put("android.support.v7.widget.ActionBarBackgroundDrawable",
				"androidx.appcompat.widget.ActionBarBackgroundDrawable");
		map.put("android.support.v7.widget.ActionBarContainer", "androidx.appcompat.widget.ActionBarContainer");
		map.put("android.support.v7.widget.ActionBarContextView", "androidx.appcompat.widget.ActionBarContextView");
		map.put("android.support.v7.widget.ActionBarOverlayLayout", "androidx.appcompat.widget.ActionBarOverlayLayout");
		map.put("android.support.v7.widget.ActionMenuPresenter", "androidx.appcompat.widget.ActionMenuPresenter");
		map.put("android.support.v7.widget.ActionMenuView", "androidx.appcompat.widget.ActionMenuView");
		map.put("android.support.v7.widget.ActivityChooserModel", "androidx.appcompat.widget.ActivityChooserModel");
		map.put("android.support.v7.widget.ActivityChooserView", "androidx.appcompat.widget.ActivityChooserView");
		map.put("android.support.v7.widget.AdapterHelper", "androidx.recyclerview.widget.AdapterHelper");
		map.put("android.support.v7.widget.AlertDialogLayout", "androidx.appcompat.widget.AlertDialogLayout");
		map.put("android.support.v7.widget.AppCompatAutoCompleteTextView",
				"androidx.appcompat.widget.AppCompatAutoCompleteTextView");
		map.put("android.support.v7.widget.AppCompatBackgroundHelper",
				"androidx.appcompat.widget.AppCompatBackgroundHelper");
		map.put("android.support.v7.widget.AppCompatButton", "androidx.appcompat.widget.AppCompatButton");
		map.put("android.support.v7.widget.AppCompatCheckBox", "androidx.appcompat.widget.AppCompatCheckBox");
		map.put("android.support.v7.widget.AppCompatCheckedTextView",
				"androidx.appcompat.widget.AppCompatCheckedTextView");
		map.put("android.support.v7.widget.AppCompatCompoundButtonHelper",
				"androidx.appcompat.widget.AppCompatCompoundButtonHelper");
		map.put("android.support.v7.widget.AppCompatDrawableManager",
				"androidx.appcompat.widget.AppCompatDrawableManager");
		map.put("android.support.v7.widget.AppCompatEditText", "androidx.appcompat.widget.AppCompatEditText");
		map.put("android.support.v7.widget.AppCompatHintHelper", "androidx.appcompat.widget.AppCompatHintHelper");
		map.put("android.support.v7.widget.AppCompatImageButton", "androidx.appcompat.widget.AppCompatImageButton");
		map.put("android.support.v7.widget.AppCompatImageHelper", "androidx.appcompat.widget.AppCompatImageHelper");
		map.put("android.support.v7.widget.AppCompatImageView", "androidx.appcompat.widget.AppCompatImageView");
		map.put("android.support.v7.widget.AppCompatMultiAutoCompleteTextView",
				"androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView");
		map.put("android.support.v7.widget.AppCompatPopupWindow", "androidx.appcompat.widget.AppCompatPopupWindow");
		map.put("android.support.v7.widget.AppCompatProgressBarHelper",
				"androidx.appcompat.widget.AppCompatProgressBarHelper");
		map.put("android.support.v7.widget.AppCompatRadioButton", "androidx.appcompat.widget.AppCompatRadioButton");
		map.put("android.support.v7.widget.AppCompatRatingBar", "androidx.appcompat.widget.AppCompatRatingBar");
		map.put("android.support.v7.widget.AppCompatSeekBar", "androidx.appcompat.widget.AppCompatSeekBar");
		map.put("android.support.v7.widget.AppCompatSeekBarHelper", "androidx.appcompat.widget.AppCompatSeekBarHelper");
		map.put("android.support.v7.widget.AppCompatSpinner", "androidx.appcompat.widget.AppCompatSpinner");
		map.put("android.support.v7.widget.AppCompatTextHelper", "androidx.appcompat.widget.AppCompatTextHelper");
		map.put("android.support.v7.widget.AppCompatTextView", "androidx.appcompat.widget.AppCompatTextView");
		map.put("android.support.v7.widget.AppCompatTextViewAutoSizeHelper",
				"androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper");
		map.put("android.support.v7.widget.ButtonBarLayout", "androidx.appcompat.widget.ButtonBarLayout");
		map.put("android.support.v7.widget.CardView", "androidx.cardview.widget.CardView");
		map.put("android.support.v7.widget.CardViewApi17Impl", "androidx.cardview.widget.CardViewApi17Impl");
		map.put("android.support.v7.widget.CardViewApi21Impl", "androidx.cardview.widget.CardViewApi21Impl");
		map.put("android.support.v7.widget.CardViewBaseImpl", "androidx.cardview.widget.CardViewBaseImpl");
		map.put("android.support.v7.widget.CardViewDelegate", "androidx.cardview.widget.CardViewDelegate");
		map.put("android.support.v7.widget.CardViewImpl", "androidx.cardview.widget.CardViewImpl");
		map.put("android.support.v7.widget.ChildHelper", "androidx.recyclerview.widget.ChildHelper");
		map.put("android.support.v7.widget.ContentFrameLayout", "androidx.appcompat.widget.ContentFrameLayout");
		map.put("android.support.v7.widget.DecorContentParent", "androidx.appcompat.widget.DecorContentParent");
		map.put("android.support.v7.widget.DecorToolbar", "androidx.appcompat.widget.DecorToolbar");
		map.put("android.support.v7.widget.DefaultItemAnimator", "androidx.recyclerview.widget.DefaultItemAnimator");
		map.put("android.support.v7.widget.DialogTitle", "androidx.appcompat.widget.DialogTitle");
		map.put("android.support.v7.widget.DividerItemDecoration",
				"androidx.recyclerview.widget.DividerItemDecoration");
		map.put("android.support.v7.widget.DrawableUtils", "androidx.appcompat.widget.DrawableUtils");
		map.put("android.support.v7.widget.DropDownListView", "androidx.appcompat.widget.DropDownListView");
		map.put("android.support.v7.widget.FastScroller", "androidx.recyclerview.widget.FastScroller");
		map.put("android.support.v7.widget.FitWindowsFrameLayout", "androidx.appcompat.widget.FitWindowsFrameLayout");
		map.put("android.support.v7.widget.FitWindowsLinearLayout", "androidx.appcompat.widget.FitWindowsLinearLayout");
		map.put("android.support.v7.widget.FitWindowsViewGroup", "androidx.appcompat.widget.FitWindowsViewGroup");
		map.put("android.support.v7.widget.ForwardingListener", "androidx.appcompat.widget.ForwardingListener");
		map.put("android.support.v7.widget.GapWorker", "androidx.recyclerview.widget.GapWorker");
		map.put("android.support.v7.widget.GridLayout", "androidx.gridlayout.widget.GridLayout");
		map.put("android.support.v7.widget.GridLayoutManager", "androidx.recyclerview.widget.GridLayoutManager");
		map.put("android.support.v7.widget.helper.ItemTouchHelper", "androidx.recyclerview.widget.ItemTouchHelper");
		map.put("android.support.v7.widget.helper.ItemTouchUIUtil", "androidx.recyclerview.widget.ItemTouchUIUtil");
		map.put("android.support.v7.widget.helper.ItemTouchUIUtilImpl",
				"androidx.recyclerview.widget.ItemTouchUIUtilImpl");
		map.put("android.support.v7.widget.LayoutState", "androidx.recyclerview.widget.LayoutState");
		map.put("android.support.v7.widget.LinearLayoutCompat", "androidx.appcompat.widget.LinearLayoutCompat");
		map.put("android.support.v7.widget.LinearLayoutManager", "androidx.recyclerview.widget.LinearLayoutManager");
		map.put("android.support.v7.widget.LinearSmoothScroller", "androidx.recyclerview.widget.LinearSmoothScroller");
		map.put("android.support.v7.widget.LinearSnapHelper", "androidx.recyclerview.widget.LinearSnapHelper");
		map.put("android.support.v7.widget.ListPopupWindow", "androidx.appcompat.widget.ListPopupWindow");
		map.put("android.support.v7.widget.MenuItemHoverListener", "androidx.appcompat.widget.MenuItemHoverListener");
		map.put("android.support.v7.widget.MenuPopupWindow", "androidx.appcompat.widget.MenuPopupWindow");
		map.put("android.support.v7.widget.OpReorderer", "androidx.recyclerview.widget.OpReorderer");
		map.put("android.support.v7.widget.OrientationHelper", "androidx.recyclerview.widget.OrientationHelper");
		map.put("android.support.v7.widget.PagerSnapHelper", "androidx.recyclerview.widget.PagerSnapHelper");
		map.put("android.support.v7.widget.PopupMenu", "androidx.appcompat.widget.PopupMenu");
		map.put("android.support.v7.widget.RecyclerView", "androidx.recyclerview.widget.RecyclerView");
		map.put("android.support.v7.widget.RecyclerViewAccessibilityDelegate",
				"androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate");
		map.put("android.support.v7.widget.ResourcesWrapper", "androidx.appcompat.widget.ResourcesWrapper");
		map.put("android.support.v7.widget.RoundRectDrawable", "androidx.cardview.widget.RoundRectDrawable");
		map.put("android.support.v7.widget.RoundRectDrawableWithShadow",
				"androidx.cardview.widget.RoundRectDrawableWithShadow");
		map.put("android.support.v7.widget.RtlSpacingHelper", "androidx.appcompat.widget.RtlSpacingHelper");
		map.put("android.support.v7.widget.ScrollbarHelper", "androidx.recyclerview.widget.ScrollbarHelper");
		map.put("android.support.v7.widget.ScrollingTabContainerView",
				"androidx.appcompat.widget.ScrollingTabContainerView");
		map.put("android.support.v7.widget.SearchView", "androidx.appcompat.widget.SearchView");
		map.put("android.support.v7.widget.ShareActionProvider", "androidx.appcompat.widget.ShareActionProvider");
		map.put("android.support.v7.widget.SimpleItemAnimator", "androidx.recyclerview.widget.SimpleItemAnimator");
		map.put("android.support.v7.widget.SnapHelper", "androidx.recyclerview.widget.SnapHelper");
		map.put("android.support.v7.widget.StaggeredGridLayoutManager",
				"androidx.recyclerview.widget.StaggeredGridLayoutManager");
		map.put("android.support.v7.widget.SuggestionsAdapter", "androidx.appcompat.widget.SuggestionsAdapter");
		map.put("android.support.v7.widget.SwitchCompat", "androidx.appcompat.widget.SwitchCompat");
		map.put("android.support.v7.widget.ThemedSpinnerAdapter", "androidx.appcompat.widget.ThemedSpinnerAdapter");
		map.put("android.support.v7.widget.ThemeUtils", "androidx.appcompat.widget.ThemeUtils");
		map.put("android.support.v7.widget.TintContextWrapper", "androidx.appcompat.widget.TintContextWrapper");
		map.put("android.support.v7.widget.TintInfo", "androidx.appcompat.widget.TintInfo");
		map.put("android.support.v7.widget.TintResources", "androidx.appcompat.widget.TintResources");
		map.put("android.support.v7.widget.TintTypedArray", "androidx.appcompat.widget.TintTypedArray");
		map.put("android.support.v7.widget.Toolbar", "androidx.appcompat.widget.Toolbar");
		map.put("android.support.v7.widget.ToolbarWidgetWrapper", "androidx.appcompat.widget.ToolbarWidgetWrapper");
		map.put("android.support.v7.widget.TooltipCompat", "androidx.appcompat.widget.TooltipCompat");
		map.put("android.support.v7.widget.TooltipCompatHandler", "androidx.appcompat.widget.TooltipCompatHandler");
		map.put("android.support.v7.widget.TooltipPopup", "androidx.appcompat.widget.TooltipPopup");
		map.put("android.support.v7.widget.util.SortedListAdapterCallback",
				"androidx.recyclerview.widget.SortedListAdapterCallback");
		map.put("android.support.v7.widget.VectorEnabledTintResources",
				"androidx.appcompat.widget.VectorEnabledTintResources");
		map.put("android.support.v7.widget.ViewBoundsCheck", "androidx.recyclerview.widget.ViewBoundsCheck");
		map.put("android.support.v7.widget.ViewInfoStore", "androidx.recyclerview.widget.ViewInfoStore");
		map.put("android.support.v7.widget.ViewStubCompat", "androidx.appcompat.widget.ViewStubCompat");
		map.put("android.support.v7.widget.ViewUtils", "androidx.appcompat.widget.ViewUtils");
		map.put("android.support.v7.widget.WithHint", "androidx.appcompat.widget.WithHint");
		map.put("android.support.wear.activity.ConfirmationActivity", "androidx.wear.activity.ConfirmationActivity");
		map.put("android.support.wear.ambient.AmbientDelegate", "androidx.wear.ambient.AmbientDelegate");
		map.put("android.support.wear.ambient.AmbientMode", "androidx.wear.ambient.AmbientMode");
		map.put("android.support.wear.ambient.AmbientModeSupport", "androidx.wear.ambient.AmbientModeSupport");
		map.put("android.support.wear.ambient.SharedLibraryVersion", "androidx.wear.ambient.SharedLibraryVersion");
		map.put("android.support.wear.ambient.WearableControllerProvider",
				"androidx.wear.ambient.WearableControllerProvider");
		map.put("android.support.wear.internal.widget.drawer.MultiPagePresenter",
				"androidx.wear.internal.widget.drawer.MultiPagePresenter");
		map.put("android.support.wear.internal.widget.drawer.MultiPageUi",
				"androidx.wear.internal.widget.drawer.MultiPageUi");
		map.put("android.support.wear.internal.widget.drawer.SinglePagePresenter",
				"androidx.wear.internal.widget.drawer.SinglePagePresenter");
		map.put("android.support.wear.internal.widget.drawer.SinglePageUi",
				"androidx.wear.internal.widget.drawer.SinglePageUi");
		map.put("android.support.wear.internal.widget.drawer.WearableNavigationDrawerPresenter",
				"androidx.wear.internal.widget.drawer.WearableNavigationDrawerPresenter");
		map.put("android.support.wear.internal.widget.ResourcesUtil", "androidx.wear.internal.widget.ResourcesUtil");
		map.put("android.support.wear.R", "androidx.wear.R");
		map.put("android.support.wear.utils.MetadataConstants", "androidx.wear.utils.MetadataConstants");
		map.put("android.support.wear.widget.BezierSCurveInterpolator",
				"androidx.wear.widget.BezierSCurveInterpolator");
		map.put("android.support.wear.widget.BoxInsetLayout", "androidx.wear.widget.BoxInsetLayout");
		map.put("android.support.wear.widget.CircledImageView", "androidx.wear.widget.CircledImageView");
		map.put("android.support.wear.widget.CircularProgressLayout", "androidx.wear.widget.CircularProgressLayout");
		map.put("android.support.wear.widget.CircularProgressLayoutController",
				"androidx.wear.widget.CircularProgressLayoutController");
		map.put("android.support.wear.widget.ConfirmationOverlay", "androidx.wear.widget.ConfirmationOverlay");
		map.put("android.support.wear.widget.CurvingLayoutCallback", "androidx.wear.widget.CurvingLayoutCallback");
		map.put("android.support.wear.widget.drawer.AbsListViewFlingWatcher",
				"androidx.wear.widget.drawer.AbsListViewFlingWatcher");
		map.put("android.support.wear.widget.drawer.FlingWatcherFactory",
				"androidx.wear.widget.drawer.FlingWatcherFactory");
		map.put("android.support.wear.widget.drawer.NestedScrollViewFlingWatcher",
				"androidx.wear.widget.drawer.NestedScrollViewFlingWatcher");
		map.put("android.support.wear.widget.drawer.PageIndicatorView",
				"androidx.wear.widget.drawer.PageIndicatorView");
		map.put("android.support.wear.widget.drawer.RecyclerViewFlingWatcher",
				"androidx.wear.widget.drawer.RecyclerViewFlingWatcher");
		map.put("android.support.wear.widget.drawer.ScrollViewFlingWatcher",
				"androidx.wear.widget.drawer.ScrollViewFlingWatcher");
		map.put("android.support.wear.widget.drawer.WearableActionDrawerMenu",
				"androidx.wear.widget.drawer.WearableActionDrawerMenu");
		map.put("android.support.wear.widget.drawer.WearableActionDrawerView",
				"androidx.wear.widget.drawer.WearableActionDrawerView");
		map.put("android.support.wear.widget.drawer.WearableDrawerController",
				"androidx.wear.widget.drawer.WearableDrawerController");
		map.put("android.support.wear.widget.drawer.WearableDrawerLayout",
				"androidx.wear.widget.drawer.WearableDrawerLayout");
		map.put("android.support.wear.widget.drawer.WearableDrawerView",
				"androidx.wear.widget.drawer.WearableDrawerView");
		map.put("android.support.wear.widget.drawer.WearableNavigationDrawerView",
				"androidx.wear.widget.drawer.WearableNavigationDrawerView");
		map.put("android.support.wear.widget.ProgressDrawable", "androidx.wear.widget.ProgressDrawable");
		map.put("android.support.wear.widget.ResourcesUtil", "androidx.wear.widget.ResourcesUtil");
		map.put("android.support.wear.widget.RoundedDrawable", "androidx.wear.widget.RoundedDrawable");
		map.put("android.support.wear.widget.ScrollManager", "androidx.wear.widget.ScrollManager");
		map.put("android.support.wear.widget.SimpleAnimatorListener", "androidx.wear.widget.SimpleAnimatorListener");
		map.put("android.support.wear.widget.SwipeDismissFrameLayout", "androidx.wear.widget.SwipeDismissFrameLayout");
		map.put("android.support.wear.widget.SwipeDismissLayout", "androidx.wear.widget.SwipeDismissLayout");
		map.put("android.support.wear.widget.WearableLinearLayoutManager",
				"androidx.wear.widget.WearableLinearLayoutManager");
		map.put("android.support.wear.widget.WearableRecyclerView", "androidx.wear.widget.WearableRecyclerView");

		return map;
	}

	/**
	 * 读取CSV文件
	 * 
	 * @param filePath 文件路径（包括文件名）
	 * @param hasTitle 是否有标题行
	 * @return
	 */
	public static Map<String, String> readCSV(String filePath, boolean hasTitle) {
		Map<String, String> map = new HashMap<String, String>();
//		List<List<String>> data = new ArrayList<>();
		String line = null;
		try {
			// BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(filePath), "utf-8"));
			if (hasTitle) {
				// 第一行信息，为标题信息
				line = bufferedReader.readLine();
				String[] items = line.split(",");
			}

//			StringBuilder sb = new StringBuilder();
//			sb.append("{");
//			boolean isFirst = true;	
			while ((line = bufferedReader.readLine()) != null) {
				// 数据行
				String[] items = line.split(",");
				map.put(items[0], items[1]);

				System.out.print("map.put(\"");
				System.out.print(items[0]);
				System.out.print("\",");
				System.out.print("\"");
				System.out.print(items[1]);
				System.out.print("\");");

//				if(!isFirst) {
//					sb.append(",");
//				}else {
//					isFirst = false;
//				}
//				
//				sb.append("\"");
//				sb.append(items[0]);
//				sb.append("\"");
//				sb.append(":");
//				sb.append("\"");
//				sb.append(items[1]);
//				sb.append("\"");
			}
//			sb.append("}");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 复制目录
	 * 
	 * @param fromDir
	 * @param toDir
	 * @throws IOException
	 */
	public static void convertDir(String fromDir, String toDir) throws IOException {
		// 创建目录的File对象
		File dirSouce = new File(fromDir);
		// 判断源目录是不是一个目录
		if (!dirSouce.isDirectory()) {
			// 如果不是目录那就不复制
			return;
		}
		// 创建目标目录的File对象
		File destDir = new File(toDir);
		// 如果目的目录不存在
		if (!destDir.exists()) {
			// 创建目的目录
			destDir.mkdir();
		}
		// 获取源目录下的File对象列表
		File[] files = dirSouce.listFiles();
		for (File file : files) {
			// 拼接新的fromDir(fromFile)和toDir(toFile)的路径
			String strFrom = fromDir + File.separator + file.getName();
			String strTo = toDir + File.separator + file.getName();
			// 判断File对象是目录还是文件
			// 判断是否是目录
			if (file.isDirectory()) {
				// 递归调用复制目录的方法
				convertDir(strFrom, strTo);
			}
			// 判断是否是文件
			if (file.isFile()) {
				// 递归调用复制文件的方法
				convertFile(strFrom, strTo);
			}
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param fromFile
	 * @param toFile
	 * @throws IOException
	 */
	public static void convertFile(String fromFile, String toFile) throws IOException {

		Map<String, String> map = new HashMap<>();
		File file = new File(fromFile);
		if (file.getName().endsWith(".java")) {

			FileOutputStream fos = new FileOutputStream(new File(toFile));
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;

			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				String pattern = "import\\sandroid.*;"; //
				String replace = "import\\s";
				boolean isMatch = Pattern.matches(pattern, s);
				if (isMatch) {

					String temp = s.replaceAll(replace, "").replace(";", "");
					String value = replaceMap.get(temp);
					if (null != value && !value.isEmpty()) {
						StringBuilder sb = new StringBuilder();
						sb.append("import ");
						sb.append(value);
						sb.append(";");
						sb.append("\n");
						bw.write(sb.toString());
					} else {
						bw.write(new String(s.getBytes("gbk"), "utf-8"));
						bw.newLine();
					}
				} else {
					bw.write(new String(s.getBytes("gbk"), "utf-8"));
					bw.newLine();
				}
			}
			br.close();
			bw.close();
			osw.close();
			fos.close();
		} else if (file.getName().endsWith(".xml")) {

			FileOutputStream fos = new FileOutputStream(new File(toFile));
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;

			String pattern = "<android.*"; //
			String patternEnd = "</android.*";
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				if (Pattern.matches(pattern, s.trim()) || Pattern.matches(patternEnd, s.trim())) {

					String key = s.replace("</", "").replace("<", "").replace(">", "").trim();

					if (key.contains(" ")) {
						String[] strs = key.split(" ");
						key = strs[0];
					}

					String value = replaceMap.get(key);
					if (null != value && !value.isEmpty()) {
						s = s.replace(key, value);
					}
					bw.write(new String(s.getBytes("gbk"), "utf-8"));
					bw.newLine();

					if (s.contains("ConstraintLayout")) {
						System.out.println("s---" + s);
						System.out.println("value--" + value);
						System.out.println("key--" + key);
					}

				} else {
					bw.write(new String(s.getBytes("gbk"), "utf-8"));
					bw.newLine();
				}
			}
			br.close();
			bw.close();
			osw.close();
			fos.close();

		} else {
			// 字节输入流——读取文件
			FileInputStream in = new FileInputStream(fromFile);
			// 字节输出流——写入文件
			FileOutputStream out = new FileOutputStream(toFile);
			// 把读取到的内容写入新文件
			// 把字节数组设置大一些 1*1024*1024=1M
			byte[] bs = new byte[1 * 1024 * 1024];
			int count = 0;
			while ((count = in.read(bs)) != -1) {
				out.write(bs, 0, count);
			}
			// 关闭流
			in.close();
			out.flush();
			out.close();
		}
	}

}
